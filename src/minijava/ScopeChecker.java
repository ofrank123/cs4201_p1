package minijava;

import minijava.symbol.MethodSignature;
import minijava.symbol.Symbol;
import minijava.symbol.SymbolTable;
import minijava.symbol.Type;

import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class ScopeChecker extends MiniJavaGrammarBaseListener {


    MiniJavaGrammarParser parser;
    HashMap<Symbol, SymbolTable> scopes = new HashMap<>();
    Deque<Symbol> scopeStack = new ArrayDeque<>();
    Symbol currentScope;
    MethodSignature currentMethod;

    boolean anyErrors;

    public void printError(String error) {
        anyErrors = true;
        System.err.println(error);
    }


    public ScopeChecker(MiniJavaGrammarParser parse) {
        this.parser = parse;
        this.anyErrors = false;
        currentScope = Symbol.symbol("Global");
        scopes.put(Symbol.symbol("Global"), new SymbolTable("Global"));
        scopeStack.push(Symbol.symbol("Global"));
    }

    SymbolTable getCurrentSymbolTable() {
        return scopes.get(currentScope);
    }

    void addBinding(String name, String typeName) {
        if (!getCurrentSymbolTable().addBinding(name, typeName)) {
            printError("Symbol " + name + " has already been used");
        }
    }

    void addMethodBinding(String name) {
        if (!getCurrentSymbolTable().addMethodBinding(name, currentMethod)) {
            printError("Symbol " + name + " has already been used");
        }
    }

    public void beginScope(String name) {
        SymbolTable oldSymboltable = getCurrentSymbolTable();
        scopeStack.push(currentScope);
        currentScope = Symbol.symbol(name);
        scopes.put(currentScope, new SymbolTable(oldSymboltable, name));
    }

    public void endScope() {
        currentScope = scopeStack.pop();
    }

    @Override
    public void enterProgram(MiniJavaGrammarParser.ProgramContext ctx) {
        beginScope("Program");
        // create a scope for the program
        System.out.println("Entered program");
    }


    @Override
    public void exitProgram(MiniJavaGrammarParser.ProgramContext ctx) {
        endScope();
        getCurrentSymbolTable().print();
        if (anyErrors) {
            System.exit(-1);
        }
    }

    @Override
    public void enterMainclass(MiniJavaGrammarParser.MainclassContext ctx) {
        beginScope(ctx.ID(0).getText());
        System.out.println(currentScope);
    }

    @Override
    public void exitMainclass(MiniJavaGrammarParser.MainclassContext ctx) {
        endScope();
    }

    @Override
    public void enterClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx) {
        String s = "something";
        beginScope(ctx.ID(0).getText());
    }

    //
    @Override
    public void exitClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx) {
        endScope();
    }

    //
    @Override
    public void enterVardecl(MiniJavaGrammarParser.VardeclContext ctx) {
        addBinding(ctx.ID().getText(), ctx.type().getText());
    }

    //
    @Override
    public void exitVardecl(MiniJavaGrammarParser.VardeclContext ctx) {

    }

    //
    @Override
    public void enterMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx) {
        beginScope(ctx.ID().getText());

        currentMethod = new MethodSignature(ctx.type().getText());
    }

    //
    @Override
    public void exitMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx) {
        endScope();

        addMethodBinding(ctx.ID().getText());
        currentMethod = null;
    }

    //
    @Override
    public void enterFormallist(MiniJavaGrammarParser.FormallistContext ctx) {
        addBinding(ctx.ID().getText(), ctx.type().getText());
        currentMethod.addParameter(ctx.type().getText());
    }

    //
    @Override
    public void exitFormallist(MiniJavaGrammarParser.FormallistContext ctx) {
    }

    //
    @Override
    public void enterFormalrest(MiniJavaGrammarParser.FormalrestContext ctx) {
        addBinding(ctx.ID().getText(), ctx.type().getText());
    }


    //
    @Override
    public void exitFormalrest(MiniJavaGrammarParser.FormalrestContext ctx) {
    }

    //
    @Override
    public void enterType(MiniJavaGrammarParser.TypeContext ctx) {

    }

    @Override
    public void exitType(MiniJavaGrammarParser.TypeContext ctx) {
        // System.out.println("exitType");
    }
//


    @Override
    public void enterStatement(MiniJavaGrammarParser.StatementContext ctx) {

    }


    @Override
    public void exitExpr(MiniJavaGrammarParser.ExprContext ctx) {
        //  System.out.println("exitExpr");
    }

    @Override
    public void enterOp(MiniJavaGrammarParser.OpContext ctx) {
        // System.out.println("enterOp");
    }

    @Override
    public void exitOp(MiniJavaGrammarParser.OpContext ctx) {
        // System.out.println("exitOp");
    }

    @Override
    public void enterExprlist(MiniJavaGrammarParser.ExprlistContext ctx) {
        //System.out.println("enterExprlist");
    }

    @Override
    public void exitExprlist(MiniJavaGrammarParser.ExprlistContext ctx) {
        //System.out.println("exitExprList");
    }

    @Override
    public void enterExprrest(MiniJavaGrammarParser.ExprrestContext ctx) {
        //System.out.println("enterExprrest");
    }

    @Override
    public void exitExprrest(MiniJavaGrammarParser.ExprrestContext ctx) {
        //System.out.println("exitExprrest");
    }
}


