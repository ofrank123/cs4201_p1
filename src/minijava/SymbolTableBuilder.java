package minijava;

import minijava.errors.*;
import minijava.symbol.MethodSignature;
import minijava.symbol.Symbol;
import minijava.symbol.SymbolTable;
import minijava.symbol.SymbolTableType;
import org.antlr.v4.runtime.ParserRuleContext;

public class SymbolTableBuilder extends MiniJavaGrammarBaseListener {
    MiniJavaGrammarParser parser;

    // Keeps track of what scope we're in
    SymbolTable currentScope;

    // Keeps track of what method we're in
    MethodSignature currentMethod;


    public SymbolTableBuilder(MiniJavaGrammarParser parse) {
        this.parser = parse;
    }

    // Wrapper for currentScope.addVarBinding
    boolean addVarBinding(String name, String typeName, boolean inMethod) {
        // Whether we are in a method determines whether the var binding
        // being declared is a local var or a class member var/argument.
        // This in turn determines whether we need to check when the var
        // is declared/initialized.
        return currentScope.addVarBinding(name, typeName, !inMethod, !inMethod);
    }

    // Wrapper for currentScope.addMethodBinding
    boolean addMethodBinding(String name) {
        return currentScope.addMethodBinding(name, currentMethod);
    }

    // Wrapper for currentScope.addClassBinding
    boolean addClassBinding(String name, Symbol extended) {
        return currentScope.addClassBinding(name, extended);
    }

    // Enter a new scope
    public void beginScope(String name, SymbolTableType tableType) {
        currentScope = new SymbolTable(currentScope, name, tableType);
    }

    // Go back to the parent scope
    public void endScope() {
        currentScope = currentScope.getParent();
    }

    /**********************************
     *       Tree Node Handlers       *
     **********************************/

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        ErrorHandler.setLinum(ctx.start.getLine());
    }

    @Override
    public void enterProgram(MiniJavaGrammarParser.ProgramContext ctx) {
        currentScope = new SymbolTable("Global");
    }


    @Override
    public void exitProgram(MiniJavaGrammarParser.ProgramContext ctx) {
        // Check for cycles in the inheritance graph
        currentScope.checkExtensionCycles();
    }

    @Override
    public void enterMainclass(MiniJavaGrammarParser.MainclassContext ctx) {
        String name = ctx.ID().getText();

        // Try adding class declaration
        if(!addClassBinding(name, null)) {
            ErrorHandler.addError(new DuplicateClassError(name));
        }
        beginScope(name, SymbolTableType.CLASS);
    }

    @Override
    public void exitMainclass(MiniJavaGrammarParser.MainclassContext ctx) {
        endScope();
    }

    @Override
    public void enterClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx) {
        String name = ctx.ID(0).getText();
        Symbol extended = null;

        // Check if class extends another class
        if (ctx.EXTENDS() != null) {
            extended = Symbol.symbol(ctx.ID(1).getText());
        }

        // Try adding class Declaration
        if(!addClassBinding(name, extended)) {
            ErrorHandler.addError(new DuplicateClassError(name));
        }

        beginScope(name, SymbolTableType.CLASS);
    }

    @Override
    public void exitClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx) {
        endScope();
    }

    @Override
    public void enterVardecl(MiniJavaGrammarParser.VardeclContext ctx) {
        String name = ctx.ID().getText();

        // Check if we're in a method
        boolean inMethod = currentScope.getTableType() == SymbolTableType.METHOD;

        // Try adding variable binding
        if (!addVarBinding(name, ctx.type().getText(), inMethod)) {
            ErrorHandler.addError(new DuplicateVariableError(name));
        }
    }

    @Override
    public void enterMainmethod(MiniJavaGrammarParser.MainmethodContext ctx) {
        String name = ctx.ID().getText();

        beginScope("main", SymbolTableType.METHOD);
        currentMethod = new MethodSignature();

        // Try to add argument to variable bindings
        if (!addVarBinding(name, "int[]", false)) {
            ErrorHandler.addError(new DuplicateArgumentError(name));
        }
        currentMethod.addParameter("int[]");
    }

    @Override
    public void exitMainmethod(MiniJavaGrammarParser.MainmethodContext ctx) {
        String name = ctx.ID().getText();

        endScope();
        // Try to add method binding
        if (!addMethodBinding("main")) {
            ErrorHandler.addError(new DuplicateMethodError(name));
        }
        currentMethod = null;
    }

    @Override
    public void enterMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx) {
        beginScope(ctx.ID().getText(), SymbolTableType.METHOD);

        // Start new method
        currentMethod = new MethodSignature(ctx.type().getText());
    }

    @Override
    public void exitMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx) {
        String name = ctx.ID().getText();

        endScope();

        // Try adding method binding
        if (!addMethodBinding(name)) {
            ErrorHandler.addError(new DuplicateMethodError(name));
        }
        currentMethod = null;

    }

    @Override
    public void enterFormallist(MiniJavaGrammarParser.FormallistContext ctx) {
        String name = ctx.ID().getText();

        // Try adding variable binding
        if (!addVarBinding(name, ctx.type().getText(), false)) {
            ErrorHandler.addError(new DuplicateArgumentError(name));
        }
        currentMethod.addParameter(ctx.type().getText());
    }

    @Override
    public void enterFormalrest(MiniJavaGrammarParser.FormalrestContext ctx) {
        String name = ctx.ID().getText();

        if (!addVarBinding(name, ctx.type().getText(), false)) {
            ErrorHandler.addError(new DuplicateArgumentError(name));
        }
        currentMethod.addParameter(ctx.type().getText());
    }
}


