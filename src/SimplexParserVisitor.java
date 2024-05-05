// Generated from /home/eduardo/Documents/Projects/simplex-language/simplex/SimplexParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimplexParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimplexParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimplexParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SimplexParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplexParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SimplexParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplexParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(SimplexParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplexParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(SimplexParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplexParser#real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal(SimplexParser.RealContext ctx);
}