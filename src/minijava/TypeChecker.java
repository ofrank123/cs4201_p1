package minijava;

import minijava.errors.*;
import minijava.symbol.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

public class TypeChecker extends MiniJavaGrammarBaseListener {
    MiniJavaGrammarParser parser;

    // Keep track of current scope
    SymbolTable currentScope;

    // Stack for evaluating types of expressions
    Deque<Type> typeStack = new ArrayDeque<>();

    // Stack for keeping track of arguments in method calls
    Deque<Integer> argsStack = new ArrayDeque<>();

    // Helpers for type checking
    Type boolType = new Type("boolean");
    Type intType = new Type("int");
    Type arrType = new Type("int[]");
    Type unknown = new Type();

    // Flag to ensure method has a return statement
    boolean methodReturns = false;

    boolean anyErrors;

    public TypeChecker(MiniJavaGrammarParser parse) {
        this.currentScope = SymbolTable.getGlobalTable();
        this.parser = parse;
        this.anyErrors = false;
    }

    // Go into child scope
    public void beginScope(String name) {
        currentScope = currentScope.getChild(name);
    }

    // Go back up to parent scope
    public void endScope() {
        currentScope = currentScope.getParent();
    }

    // Check if types are different
    private boolean typesDiffer(Type actual, Type expected) {
        return !expected.equals(actual) && !SymbolTable.getGlobalTable().classExtends(actual.getName(), expected.getName());
    }

    /**********************************
     *       Tree Node Handlers       *
     **********************************/

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        // Set linum before handling each node
        ErrorHandler.setLinum(ctx.start.getLine());
    }

    @Override
    public void enterProgram(MiniJavaGrammarParser.ProgramContext ctx) {
    }

    @Override
    public void enterMainclass(MiniJavaGrammarParser.MainclassContext ctx) {
        TerminalNode id = ctx.ID();
        beginScope(id.getText());
    }

    @Override
    public void exitMainclass(MiniJavaGrammarParser.MainclassContext ctx) {
        endScope();
    }

    @Override
    public void enterClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx) {
        beginScope(ctx.ID(0).getText());
    }

    @Override
    public void exitClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx) {
        endScope();
    }

    @Override
    public void enterMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx) {
        beginScope(ctx.ID().getText());
    }

    @Override
    public void exitMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx) {
        MethodSignature currentMethod = currentScope.getEnclosingClass().getMethodSig(currentScope.getName());

        // Check that method returns something, if it's supposed to
        if (currentMethod.getReturnType() != null && !methodReturns) {
            ErrorHandler.addError(new NoMethodReturnError(ctx.ID().getText(), currentMethod.getReturnType().toString()));
        }

        // Reset flag
        methodReturns = false;
        endScope();
    }

    @Override
    public void enterMainmethod(MiniJavaGrammarParser.MainmethodContext ctx) {
        beginScope("main");
    }

    @Override
    public void exitMainmethod(MiniJavaGrammarParser.MainmethodContext ctx) {
        endScope();
    }

    @Override
    public void enterVardecl(MiniJavaGrammarParser.VardeclContext ctx) {
        currentScope.declareVar(ctx.ID().getText());
    }

    @Override
    public void exitIf(MiniJavaGrammarParser.IfContext ctx) {
        Type ifClause = typeStack.pop();

        // Check that the if clause is a bool
        if (typesDiffer(ifClause, boolType)) {
            ErrorHandler.addError(new IfTypeError(ifClause));
        }
    }

    @Override
    public void exitWhile(MiniJavaGrammarParser.WhileContext ctx) {
        Type whileClause = typeStack.pop();

        // Check that the while clause is a bool
        if (typesDiffer(whileClause, boolType)) {
            ErrorHandler.addError(new WhileTypeError(whileClause));
        }
    }

    @Override
    public void exitPrint(MiniJavaGrammarParser.PrintContext ctx) {
        // We can print any type, so just pop the type off the stack
        typeStack.pop();
    }

    @Override
    public void exitAssignment(MiniJavaGrammarParser.AssignmentContext ctx) {
        String name = ctx.ID().getText();
        Type rhs = typeStack.pop();
        Type lhs = currentScope.getVarType(name);

        // Check if var on the left hand side exists
        if (lhs == null) {
            ErrorHandler.addError(new VarNotFoundError(name));
            return;
        }

        // Check types match between lhs and rhs
        if (typesDiffer(rhs, lhs)) {
            ErrorHandler.addError(new AssignmentTypeError(name, lhs, rhs));
        }

        // Check that variable has been declared
        boolean declared = currentScope.isVarDeclared(name);
        if (!declared) {
            ErrorHandler.addError(new AssignmentBeforeDeclarationError(name));
        }

        // We can now instantiate the variable, as it has been assigned
        currentScope.instantiateVar(name);
    }

    @Override
    public void exitArrayAssignment(MiniJavaGrammarParser.ArrayAssignmentContext ctx) {
        String name = ctx.ID().getText();
        Type val = typeStack.pop();
        Type idx = typeStack.pop();

        // Check type element is being assigned to
        if (typesDiffer(val, intType)) {
            ErrorHandler.addError(new ArrayAssignmentTypeError(name, val));
        }

        // Check type of index
        if (typesDiffer(idx, intType)) {
            ErrorHandler.addError(new ArrayIndexTypeError(name, idx));
        }

        // Check that array exists
        Type lhs = currentScope.getVarType(name);
        if (lhs == null) {
            ErrorHandler.addError(new VarNotFoundError(name));
            return;
        }

        // Check that array is actually an array
        if (typesDiffer(lhs, arrType)) {
            ErrorHandler.addError(new NonArrayIndexError(name, lhs));
        }

        // Check that array is declared
        boolean declared = currentScope.isVarDeclared(name);
        if (!declared) {
            ErrorHandler.addError(new IndexBeforeDeclarationError(name));
        }

        // Check that array is instantiated
        boolean instant = currentScope.isVarInstantiated(name);
        if (!instant) {
            ErrorHandler.addError(new IndexBeforeInstantiationError(name));
        }
    }

    @Override
    public void exitReturn(MiniJavaGrammarParser.ReturnContext ctx) {
        MethodSignature currentMethod = currentScope.getParent().getMethodSig(currentScope.getName());
        Type t = typeStack.pop();

        // Check that return type matches method return type
        if (!currentMethod.getReturnType().equals(t)) {
            ErrorHandler.addError(new ReturnTypeError(t, currentMethod.getReturnType()));
        }

        methodReturns = true;
    }

    @Override
    public void exitOpExpr(MiniJavaGrammarParser.OpExprContext ctx) {
        Type t1 = typeStack.pop();
        Type t2 = typeStack.pop();
        String op = ctx.op().getText();

        if (ctx.op().AND() != null) {
            if (typesDiffer(t1, boolType))
                ErrorHandler.addError(new OperatorTypeError(op, t1, boolType));
            else if (typesDiffer(t2, boolType))
                ErrorHandler.addError(new OperatorTypeError(op, t2, boolType));
            typeStack.push(boolType);
        } else {
            if (typesDiffer(t1, intType))
                ErrorHandler.addError(new OperatorTypeError(op, t1, intType));
            else if (typesDiffer(t2, intType))
                ErrorHandler.addError(new OperatorTypeError(op, t2, intType));
            if (ctx.op().LT() != null) {
                typeStack.push(boolType);
            } else {
                typeStack.push(intType);
            }
        }
    }

    @Override
    public void exitIndexExpr(MiniJavaGrammarParser.IndexExprContext ctx) {
        String name = ctx.expr(0).getText();
        Type idx = typeStack.pop();
        Type arr = typeStack.pop();

        // Check type of index
        if (typesDiffer(idx, intType)) {
            ErrorHandler.addError(new ArrayIndexTypeError(name, idx));
        }
        // check that we're indexing an array
        if (typesDiffer(arr, arrType)) {
            ErrorHandler.addError(new NonArrayIndexError(name, arr));
        }
        // If the expr is a variable, check if it's declared and instantiated
        if (currentScope.isVar(name)) {
            if (!currentScope.isVarDeclared(name)) {
                ErrorHandler.addError(new IndexBeforeDeclarationError(name));
            }
            if (!currentScope.isVarInstantiated(name)) {
                ErrorHandler.addError(new IndexBeforeInstantiationError(name));
            }
        }
        typeStack.push(intType);
    }

    @Override
    public void exitLengthExpr(MiniJavaGrammarParser.LengthExprContext ctx) {
        Type arr = typeStack.pop();
        if (typesDiffer(arr, arrType)) {
            ErrorHandler.addError(new NonArrayLengthError(arr));
        }
        typeStack.push(intType);
    }

    @Override
    public void enterMethodExpr(MiniJavaGrammarParser.MethodExprContext ctx) {
        argsStack.push(0);
    }

    @Override
    public void exitMethodExpr(MiniJavaGrammarParser.MethodExprContext ctx) {
        String methodName = ctx.ID().getText();

        ArrayList<Type> argTypes = new ArrayList<>();
        int argsOnStack = argsStack.pop();
        while (argsOnStack > 0) {
            // Add at front to reverse order of args
            argTypes.add(0, typeStack.pop());
            argsOnStack--;
        }

        // Check that the "class" being popped is actually a class
        Type cls = typeStack.pop();
        if (cls.getType() != TypeE.ID) {
            ErrorHandler.addError(new ClassExpectedError(cls));
            typeStack.push(unknown);
            return;
        }

        // Check that class exists in scope
        SymbolTable clsTable = currentScope.getClassTable(cls.getName());
        if (clsTable == null) {
            ErrorHandler.addError(new ClassNotFoundError(cls.toString()));
            typeStack.push(unknown);
            return;
        }

        // Check that method exists on class
        MethodSignature sig = clsTable.getMethodSig(Symbol.symbol(methodName));
        if (sig == null){
            ErrorHandler.addError(new MethodNotFoundError(methodName, cls));
            typeStack.push(unknown);
            return;
        }

        // Check number of arguments
        if (argTypes.size() != sig.getParameters().size()) {
            ErrorHandler.addError(new MethodArgumentCountError(methodName, sig, argTypes.size()));
            typeStack.push(unknown);
            return;
        }

        // Check types of arguments
        Iterator<Type> argIter = argTypes.iterator();
        Iterator<Type> paramIter = sig.getParameters().iterator();
        while (argIter.hasNext()) {
            Type arg = argIter.next();
            Type param = paramIter.next();
            if (typesDiffer(arg, param)) {
                ErrorHandler.addError(new MethodArgumentTypeError(methodName, arg, param));
            }
        }

        typeStack.push(sig.getReturnType());
    }

    @Override
    public void enterExprlist(MiniJavaGrammarParser.ExprlistContext ctx) {
        int argsOnStack = argsStack.pop();
        argsOnStack++;
        argsStack.push(argsOnStack);
    }

    @Override
    public void enterExprrest(MiniJavaGrammarParser.ExprrestContext ctx) {
        int argsOnStack = argsStack.pop();
        argsOnStack++;
        argsStack.push(argsOnStack);
    }

    @Override
    public void exitIntegerExpr(MiniJavaGrammarParser.IntegerExprContext ctx) {
        typeStack.push(intType);
    }

    @Override
    public void exitBooleanExpr(MiniJavaGrammarParser.BooleanExprContext ctx) {
        if (ctx.expr() != null) {
            Type t = typeStack.pop();
            if (typesDiffer(t, boolType)) {
                ErrorHandler.addError(new BoolTypeError(t));
            }
        }

        typeStack.push(boolType);
    }

    @Override
    public void exitIdExpr(MiniJavaGrammarParser.IdExprContext ctx) {
        String name = ctx.ID().getText();
        Type idType = currentScope.getType(name);
        // Check if identifier exists
        if (idType == null) {
            ErrorHandler.addError(new IdentifierNotFoundError(name));
            typeStack.push(unknown);
        } else {
            // Check if variable is not initialized
            typeStack.push(currentScope.getType(name));
            if (currentScope.isVar(name) && !currentScope.isVarInstantiated(name)) {
                ErrorHandler.addError(new VarNotInitializedError(name));
            }
        }
    }

    @Override
    public void exitThisExpr(MiniJavaGrammarParser.ThisExprContext ctx) {
        SymbolTable cls = currentScope.getEnclosingClass();
        // We know cls won't be null because the syntax doesn't allow for
        // this outside of a class setting
        typeStack.push(new Type(cls.getName().toString()));
    }

    @Override
    public void exitNewArrExpr(MiniJavaGrammarParser.NewArrExprContext ctx) {
        // Check type of inner array
        Type t = typeStack.pop();
        if (typesDiffer(t, intType)) {
            ErrorHandler.addError(new NewArrayTypeError(t));
        }

        typeStack.push(arrType);
    }

    @Override
    public void exitNewClassExpr(MiniJavaGrammarParser.NewClassExprContext ctx) {
        TerminalNode id = ctx.ID();
        Type clsType = currentScope.getClassType(id.getText());

        if (clsType != null) {
            typeStack.push(clsType);
        } else {
            ErrorHandler.addError(new ClassNotFoundError(id.getText()));
            // We push this type regardless of error so something is on the stack
            typeStack.push(new Type(id.getText()));
        }
    }

    @Override
    public void exitParenExpr(MiniJavaGrammarParser.ParenExprContext ctx) {
        // Nothing happens, whatever is on top of the stack should stay the same
    }
}