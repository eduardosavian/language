// Generated from /home/eduardo/Documents/Projects/simplex-language/simplex/SimplexParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimplexParser}.
 */
public interface SimplexParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimplexParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimplexParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplexParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimplexParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplexParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimplexParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplexParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimplexParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplexParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(SimplexParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplexParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(SimplexParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplexParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(SimplexParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplexParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(SimplexParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplexParser#real}.
	 * @param ctx the parse tree
	 */
	void enterReal(SimplexParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplexParser#real}.
	 * @param ctx the parse tree
	 */
	void exitReal(SimplexParser.RealContext ctx);
}