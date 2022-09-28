package minijava;

import minijava.symbol.Symbol;
import minijava.symbol.SymbolTable;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class ScopeChecker extends MiniJavaGrammarBaseListener {


    MiniJavaGrammarParser parser;
    HashMap<Symbol, SymbolTable> scopes = new HashMap<>();
    Deque<Symbol> scopeStack = new ArrayDeque<>();
    Symbol currentScope;

    boolean anyErrors;

    public void printError(String error) {
        anyErrors = true;
        System.err.println(error);
    }


    public ScopeChecker(MiniJavaGrammarParser parse) {
        this.parser = parse;
        this.anyErrors = false;
        scopes.put(Symbol.symbol("Global"), new SymbolTable());
        scopeStack.push(Symbol.symbol("Global"));
    }

    public void beginScope(String name) {
        scopeStack.push(currentScope);
        SymbolTable oldScope = scopes.get(currentScope);
        currentScope = Symbol.symbol(name);
        scopes.put(Symbol.symbol(name), oldScope);
    }

    public void endScope(String name) {
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
        if (anyErrors) {
            System.exit(-1);
        }
    }

    @Override
    public void enterMainclass(MiniJavaGrammarParser.MainclassContext ctx) {
        System.out.println("Entered main class");

    }

    //
    @Override
    public void exitMainclass(MiniJavaGrammarParser.MainclassContext ctx) {
//      //  System.out.println("exitMainClass");
    }

    //
    @Override
    public void enterClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx) {
//
//
    }

    //
    @Override
    public void exitClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx) {

    }

    //
    @Override
    public void enterVardecl(MiniJavaGrammarParser.VardeclContext ctx) {


    }

    //
    @Override
    public void exitVardecl(MiniJavaGrammarParser.VardeclContext ctx) {

    }

    //
    @Override
    public void enterMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx) {

    }

    //
    @Override
    public void exitMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx) {

    }

    //
    @Override
    public void enterFormallist(MiniJavaGrammarParser.FormallistContext ctx) {

    }

    //
    @Override
    public void exitFormallist(MiniJavaGrammarParser.FormallistContext ctx) {
        System.out.println(ctx.ID().getSymbol().getText());
    }

    //
    @Override
    public void enterFormalrest(MiniJavaGrammarParser.FormalrestContext ctx) {

    }


    //
    @Override
    public void exitFormalrest(MiniJavaGrammarParser.FormalrestContext ctx) {
        System.out.println("exitFormalrest");
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


