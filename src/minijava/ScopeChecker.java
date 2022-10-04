package minijava;

import minijava.symbol.MethodSignature;
import minijava.symbol.Symbol;
import minijava.symbol.SymbolTable;
import minijava.symbol.SymbolTableType;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ScopeChecker extends MiniJavaGrammarBaseListener {
    MiniJavaGrammarParser parser;
    SymbolTable currentScope;
    MethodSignature currentMethod;

    boolean anyErrors;

    public void printError(int linum, String error) {
        anyErrors = true;
        System.err.println("Error: line " + linum + ": " + error);
    }


    public ScopeChecker(MiniJavaGrammarParser parse) {
        this.parser = parse;
        this.anyErrors = false;
    }

    public SymbolTable getSymbolTable() {
        return this.currentScope;
    }

    boolean addBinding(String name, String typeName) {
        return currentScope.addBinding(name, typeName);
    }

    boolean addMethodBinding(String name) {
        return currentScope.addMethodBinding(name, currentMethod);
    }

    boolean addClassDecl(String name) {
        return currentScope.addClassDecl(name);
    }

    public void beginScope(String name, SymbolTableType tableType) {
        currentScope = new SymbolTable(currentScope, name, tableType);
    }

    public void endScope() {
        currentScope = currentScope.getParent();
    }

    @Override
    public void enterProgram(MiniJavaGrammarParser.ProgramContext ctx) {
        currentScope = new SymbolTable("Global");
    }


    @Override
    public void exitProgram(MiniJavaGrammarParser.ProgramContext ctx) {
        if (anyErrors) {
            System.exit(-1);
        }
        currentScope.print();
    }

    @Override
    public void enterMainclass(MiniJavaGrammarParser.MainclassContext ctx) {
        TerminalNode id = ctx.ID();
        if(!addClassDecl(id.getText())) {
            printError(id.getSymbol().getLine(), "Duplicate class " + id.getText());
        }
        beginScope(id.getText(), SymbolTableType.CLASS);
    }

    @Override
    public void exitMainclass(MiniJavaGrammarParser.MainclassContext ctx) {
        endScope();
    }

    @Override
    public void enterClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx) {
        TerminalNode id = ctx.ID(0);
        if(!addClassDecl(id.getText())) {
            printError(id.getSymbol().getLine(), "Duplicate class " + id.getText());
        }
        beginScope(id.getText(), SymbolTableType.CLASS);
    }

    @Override
    public void exitClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx) {
        endScope();
    }

    @Override
    public void enterVardecl(MiniJavaGrammarParser.VardeclContext ctx) {
        TerminalNode id = ctx.ID();
        if (!addBinding(id.getText(), ctx.type().getText())) {
            printError(id.getSymbol().getLine(), "Cannt declare variable " + ctx.ID().getText() + ", symbol already used");
        }
    }

    @Override
    public void enterMainmethod(MiniJavaGrammarParser.MainmethodContext ctx) {
        TerminalNode id = ctx.ID();

        beginScope("main", SymbolTableType.METHOD);
        currentMethod = new MethodSignature();
        if (!addBinding("args", "int[]")) {
            printError(id.getSymbol().getLine(), "Cannot declare argument " + id.getText() + ", symbol already used");
        }
        currentMethod.addParameter("int[]");
    }

    @Override
    public void exitMainmethod(MiniJavaGrammarParser.MainmethodContext ctx) {
        TerminalNode id = ctx.ID();
        endScope();
        if (!addMethodBinding("main")) {
            printError(id.getSymbol().getLine(), "Cannot declare method " + id.getText() + ", symbol already used");
        }
        currentMethod = null;
    }

    @Override
    public void enterMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx) {
        beginScope(ctx.ID().getText(), SymbolTableType.METHOD);

        currentMethod = new MethodSignature(ctx.type().getText());
    }

    @Override
    public void exitMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx) {
        TerminalNode id = ctx.ID();
        endScope();
        if (!addMethodBinding(id.getText())) {
            printError(id.getSymbol().getLine(), "Cannot declare method " + id.getText() + ", symbol already used");
        }
        currentMethod = null;

    }

    @Override
    public void enterFormallist(MiniJavaGrammarParser.FormallistContext ctx) {
        TerminalNode id = ctx.ID();
        if (!addBinding(id.getText(), ctx.type().getText())) {
            printError(id.getSymbol().getLine(), "Cannot declare argument " + id.getText() + ", symbol already used");
        }
        currentMethod.addParameter(ctx.type().getText());
    }

    @Override
    public void enterFormalrest(MiniJavaGrammarParser.FormalrestContext ctx) {
        TerminalNode id = ctx.ID();

        if (!addBinding(id.getText(), ctx.type().getText())) {
            printError(id.getSymbol().getLine(), "Cannot declare argument " + id.getText() + ", symbol already used");
        }
        currentMethod.addParameter(ctx.type().getText());
    }

    @Override
    public void enterAssignment(MiniJavaGrammarParser.AssignmentContext ctx){
        // Check if var is declared
    }

    @Override
    public void enterArrayAssignment(MiniJavaGrammarParser.ArrayAssignmentContext ctx){
        // Check if var is declared
    }
}


