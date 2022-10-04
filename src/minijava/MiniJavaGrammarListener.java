// Generated from MiniJavaGrammar.g by ANTLR 4.7.2
package minijava;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaGrammarParser}.
 */
public interface MiniJavaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniJavaGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniJavaGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#mainclass}.
	 * @param ctx the parse tree
	 */
	void enterMainclass(MiniJavaGrammarParser.MainclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#mainclass}.
	 * @param ctx the parse tree
	 */
	void exitMainclass(MiniJavaGrammarParser.MainclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#mainmethod}.
	 * @param ctx the parse tree
	 */
	void enterMainmethod(MiniJavaGrammarParser.MainmethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#mainmethod}.
	 * @param ctx the parse tree
	 */
	void exitMainmethod(MiniJavaGrammarParser.MainmethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#classdecl}.
	 * @param ctx the parse tree
	 */
	void enterClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#classdecl}.
	 * @param ctx the parse tree
	 */
	void exitClassdecl(MiniJavaGrammarParser.ClassdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void enterVardecl(MiniJavaGrammarParser.VardeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void exitVardecl(MiniJavaGrammarParser.VardeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#methoddecl}.
	 * @param ctx the parse tree
	 */
	void enterMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#methoddecl}.
	 * @param ctx the parse tree
	 */
	void exitMethoddecl(MiniJavaGrammarParser.MethoddeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#methodbody}.
	 * @param ctx the parse tree
	 */
	void enterMethodbody(MiniJavaGrammarParser.MethodbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#methodbody}.
	 * @param ctx the parse tree
	 */
	void exitMethodbody(MiniJavaGrammarParser.MethodbodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#formallist}.
	 * @param ctx the parse tree
	 */
	void enterFormallist(MiniJavaGrammarParser.FormallistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#formallist}.
	 * @param ctx the parse tree
	 */
	void exitFormallist(MiniJavaGrammarParser.FormallistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#formalrest}.
	 * @param ctx the parse tree
	 */
	void enterFormalrest(MiniJavaGrammarParser.FormalrestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#formalrest}.
	 * @param ctx the parse tree
	 */
	void exitFormalrest(MiniJavaGrammarParser.FormalrestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniJavaGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniJavaGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBraces(MiniJavaGrammarParser.BracesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBraces(MiniJavaGrammarParser.BracesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code If}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIf(MiniJavaGrammarParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code If}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIf(MiniJavaGrammarParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile(MiniJavaGrammarParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile(MiniJavaGrammarParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Print}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrint(MiniJavaGrammarParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrint(MiniJavaGrammarParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniJavaGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniJavaGrammarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAssignment}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignment(MiniJavaGrammarParser.ArrayAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAssignment}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignment(MiniJavaGrammarParser.ArrayAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Return}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn(MiniJavaGrammarParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link MiniJavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn(MiniJavaGrammarParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntegerExpr(MiniJavaGrammarParser.IntegerExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntegerExpr(MiniJavaGrammarParser.IntegerExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(MiniJavaGrammarParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(MiniJavaGrammarParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMethodExpr(MiniJavaGrammarParser.MethodExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMethodExpr(MiniJavaGrammarParser.MethodExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LengthExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLengthExpr(MiniJavaGrammarParser.LengthExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LengthExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLengthExpr(MiniJavaGrammarParser.LengthExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewArrExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNewArrExpr(MiniJavaGrammarParser.NewArrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewArrExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNewArrExpr(MiniJavaGrammarParser.NewArrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewClassExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNewClassExpr(MiniJavaGrammarParser.NewClassExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewClassExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNewClassExpr(MiniJavaGrammarParser.NewClassExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(MiniJavaGrammarParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(MiniJavaGrammarParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOpExpr(MiniJavaGrammarParser.OpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOpExpr(MiniJavaGrammarParser.OpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpr(MiniJavaGrammarParser.BooleanExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpr(MiniJavaGrammarParser.BooleanExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ThisExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(MiniJavaGrammarParser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ThisExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(MiniJavaGrammarParser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpr(MiniJavaGrammarParser.IndexExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexExpr}
	 * labeled alternative in {@link MiniJavaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpr(MiniJavaGrammarParser.IndexExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(MiniJavaGrammarParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(MiniJavaGrammarParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void enterExprlist(MiniJavaGrammarParser.ExprlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void exitExprlist(MiniJavaGrammarParser.ExprlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaGrammarParser#exprrest}.
	 * @param ctx the parse tree
	 */
	void enterExprrest(MiniJavaGrammarParser.ExprrestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaGrammarParser#exprrest}.
	 * @param ctx the parse tree
	 */
	void exitExprrest(MiniJavaGrammarParser.ExprrestContext ctx);
}