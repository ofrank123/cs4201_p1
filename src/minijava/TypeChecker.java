package minijava;

import minijava.symbol.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

public class TypeChecker extends MiniJavaGrammarBaseListener {
    MiniJavaGrammarParser parser;
    SymbolTable currentScope;
    Deque<Type> typeStack = new ArrayDeque<>();
    int argsOnStack = 0;

    Type boolType = new Type("boolean");
    Type intType = new Type("int");
    Type arrType = new Type("int[]");
    Type unknown = new Type();

    boolean anyErrors;

    public void printError(int linum, String error) {
        anyErrors = true;
        System.err.println("Error: line " + linum + ": " + error);
    }


    public TypeChecker(MiniJavaGrammarParser parse, SymbolTable globalScope) {
        this.currentScope = globalScope;
        this.parser = parse;
        this.anyErrors = false;
    }

    public void beginScope(String name) {
        currentScope = currentScope.getChild(name);
    }

    public void endScope() {
        currentScope = currentScope.getParent();
    }


    private void checkType(int linum, Type actual, Type expected) {
        if (!expected.equals(actual)) {
            printError(linum, "Expected " + expected.getName() + " found " + actual.getName());
        }
    }

    @Override
    public void enterProgram(MiniJavaGrammarParser.ProgramContext ctx) {
    }


    @Override
    public void exitProgram(MiniJavaGrammarParser.ProgramContext ctx) {
        if (anyErrors) {
            System.exit(-1);
        }
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
    public void exitIf(MiniJavaGrammarParser.IfContext ctx) {
        Type ifClause = typeStack.pop();
        checkType(ctx.start.getLine(), ifClause, boolType);
    }

    @Override
    public void exitWhile(MiniJavaGrammarParser.WhileContext ctx) {
        Type whileClause = typeStack.pop();
        checkType(ctx.start.getLine(), whileClause, boolType);
    }

    @Override
    public void exitPrint(MiniJavaGrammarParser.PrintContext ctx) {
        // We can print any type, so just pop the type off the stack
        typeStack.pop();
    }

    @Override
    public void exitAssignment(MiniJavaGrammarParser.AssignmentContext ctx) {
        int linum = ctx.start.getLine();
        TerminalNode id = ctx.ID();
        Type rhs = typeStack.pop();
        Type lhs = currentScope.getType(id.getText());
        if (lhs == null) {
            printError(linum, "No such identifier: " + id.getText());
            return;
        }
        checkType(ctx.start.getLine(), rhs, lhs);
    }

    @Override
    public void exitArrayAssignment(MiniJavaGrammarParser.ArrayAssignmentContext ctx) {
        int linum = ctx.start.getLine();
        TerminalNode id = ctx.ID();
        Type val = typeStack.pop();
        Type idx = typeStack.pop();
        checkType(linum, val, intType);
        checkType(linum, idx, intType);

        Type lhs = currentScope.getType(id.getText());
        if (lhs == null) {
            printError(linum, "No such identifier: " + id.getText());
            return;
        }
        checkType(linum, lhs, arrType);
    }

    @Override
    public void exitOpExpr(MiniJavaGrammarParser.OpExprContext ctx) {
        Type t1 = typeStack.pop();
        Type t2 = typeStack.pop();
        int linum = ctx.start.getLine();

        if (ctx.op().AND() != null) {
            checkType(linum, t1, boolType);
            checkType(linum, t2, boolType);
            typeStack.push(boolType);
        } else {
            checkType(linum, t1, intType);
            checkType(linum, t2, intType);
            if (ctx.op().LT() != null) {
                typeStack.push(boolType);
            } else {
                typeStack.push(intType);
            }
        }
    }

    @Override
    public void exitIndexExpr(MiniJavaGrammarParser.IndexExprContext ctx) {
        int linum = ctx.start.getLine();
        Type idx = typeStack.pop();
        Type arr = typeStack.pop();
        checkType(linum, idx, intType);
        checkType(linum, arr, arrType);
        typeStack.push(intType);
    }

    @Override
    public void exitLengthExpr(MiniJavaGrammarParser.LengthExprContext ctx) {
        int linum = ctx.start.getLine();
        Type arr = typeStack.pop();
        checkType(linum, arr, arrType);
    }

    @Override
    public void exitMethodExpr(MiniJavaGrammarParser.MethodExprContext ctx) {
        int linum = ctx.start.getLine();
        TerminalNode id = ctx.ID();
        ArrayList<Type> argTypes = new ArrayList<>();
        while (argsOnStack > 0) {
            // Add at front to reverse order of args
            argTypes.add(0, typeStack.pop());
            argsOnStack--;
        }
        Type cls = typeStack.pop();
        if (cls.getType() != TypeE.ID) {
            printError(linum, "Expected class, received " + cls.getName());
            typeStack.push(unknown);
            return;
        }
        SymbolTable clsTable = currentScope.getClassTable(cls.getName());
        if (clsTable == null) {
            printError(linum, "Class type " + cls.getName() + " not found");
            typeStack.push(unknown);
            return;
        }

        MethodSignature sig = clsTable.getMethodSig(Symbol.symbol(ctx.ID().getText()));
        if (sig == null){
            printError(linum, "Method " + id.getText() + " not found ");
            typeStack.push(unknown);
            return;
        }
        if (argTypes.size() != sig.getParameters().size()) {
            printError(linum, "Method " + id.getText() + " takes " + sig.getParameters().size() + " arguments, found " + argTypes.size());
            typeStack.push(unknown);
            return;
        }
        Iterator<Type> argIter = argTypes.iterator();
        Iterator<Type> paramIter = sig.getParameters().iterator();
        while (argIter.hasNext()) {
            Type arg = argIter.next();
            Type param = paramIter.next();
            checkType(linum, arg, param);
        }

        typeStack.push(sig.getReturnType());
    }

    @Override
    public void exitExprlist(MiniJavaGrammarParser.ExprlistContext ctx) {
        // The type is already on the stack in the correct position
        // We just need to increment the args counter
        argsOnStack++;
    }

    @Override
    public void exitExprrest(MiniJavaGrammarParser.ExprrestContext ctx) {
        // The type is already on the stack in the correct position
        // We just need to increment the args counter
        argsOnStack++;
    }

    @Override
    public void exitIntegerExpr(MiniJavaGrammarParser.IntegerExprContext ctx) {
        typeStack.push(intType);
    }

    @Override
    public void exitBooleanExpr(MiniJavaGrammarParser.BooleanExprContext ctx) {
        if (ctx.expr() != null) {
            Type t = typeStack.pop();
            checkType(ctx.start.getLine(), t, boolType);
        }

        typeStack.push(boolType);
    }

    @Override
    public void exitIdExpr(MiniJavaGrammarParser.IdExprContext ctx) {
        int linum = ctx.start.getLine();
        TerminalNode id = ctx.ID();
        Type idType = currentScope.getType(id.getText());
        if (idType == null) {
            printError(linum, "Could not find identifier: " + id.getText());
            typeStack.push(unknown);
        } else {
            typeStack.push(currentScope.getType(id.getText()));
        }
    }

    @Override
    public void exitThisExpr(MiniJavaGrammarParser.ThisExprContext ctx) {
        SymbolTable cls = currentScope.getEnclosingClass();
        if (cls != null) {
            typeStack.push(new Type(cls.getName().toString()));
        } else {
            printError(ctx.start.getLine(), "Keyword \"this\" cannot be used outside of a class context");
            typeStack.push(unknown);
        }
    }

    @Override
    public void exitNewArrExpr(MiniJavaGrammarParser.NewArrExprContext ctx) {
        // Check type of inner array
        Type t = typeStack.pop();
        checkType(ctx.start.getLine(), t, intType);

        typeStack.push(arrType);
    }

    @Override
    public void exitNewClassExpr(MiniJavaGrammarParser.NewClassExprContext ctx) {
        TerminalNode id = ctx.ID();
        Type clsType = currentScope.getClassType(id.getText());

        if (clsType != null) {
            typeStack.push(clsType);
        } else {
            printError(ctx.start.getLine(), "Class " + id.getText() + " not defined");
            // We push this type regardless of error so something is on the stack
            typeStack.push(new Type(id.getText()));
        }
    }

    @Override
    public void exitParenExpr(MiniJavaGrammarParser.ParenExprContext ctx) {
        // Nothing happens, whatever is on top of the stack should stay the same
    }
}