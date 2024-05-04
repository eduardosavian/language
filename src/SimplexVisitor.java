import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SimplexVisitor extends SimplexParserBaseVisitor<Integer> {
    private Deque<String> scopeStack = new ArrayDeque<>();
    ArrayList<Symbol> vars = new ArrayList<Symbol>();
    private Integer scopeCounter = 0;

    @Override
    public Integer visitBitShift(SimplexParser.BitShiftContext ctx) {

        return super.visitBitShift(ctx);
    }

    @Override
    public Integer visitBreakStatement(SimplexParser.BreakStatementContext ctx) {

        return super.visitBreakStatement(ctx);
    }

    @Override
    public Integer visitComparison(SimplexParser.ComparisonContext ctx) {

        return super.visitComparison(ctx);
    }

    @Override
    public Integer visitContinueStatement(SimplexParser.ContinueStatementContext ctx) {

        return super.visitContinueStatement(ctx);
    }

    @Override
    public Integer visitDoFor(SimplexParser.DoForContext ctx) {

        return super.visitDoFor(ctx);
    }

    @Override
    public Integer visitExprStatement(SimplexParser.ExprStatementContext ctx) {

        return super.visitExprStatement(ctx);
    }

    @Override
    public Integer visitExpression(SimplexParser.ExpressionContext ctx) {

        return super.visitExpression(ctx);
    }

    @Override
    public Integer visitExpressionList(SimplexParser.ExpressionListContext ctx) {

        return super.visitExpressionList(ctx);
    }

    @Override
    public Integer visitFactor(SimplexParser.FactorContext ctx) {

        return super.visitFactor(ctx);
    }

    @Override
    public Integer visitField(SimplexParser.FieldContext ctx) {

        return super.visitField(ctx);
    }

    @Override
    public Integer visitFieldList(SimplexParser.FieldListContext ctx) {

        return super.visitFieldList(ctx);
    }

    @Override
    public Integer visitFuncDeclaration(SimplexParser.FuncDeclarationContext ctx) {
        // TODO Auto-generated method stub

        return super.visitFuncDeclaration(ctx);
    }

    @Override
    public Integer visitFunctionCall(SimplexParser.FunctionCallContext ctx) {
        // TODO Auto-generated method stub

        return super.visitFunctionCall(ctx);
    }

    @Override
    public Integer visitGroup(SimplexParser.GroupContext ctx) {
        // TODO Auto-generated method stub

        return super.visitGroup(ctx);
    }

    public Integer visitIdentifierList(SimplexParser.IdentifierListContext ctx) {
        
        return super.visitIdentifierList(ctx);
    }


    @Override
    public Integer visitIfStatement(SimplexParser.IfStatementContext ctx) {

        return super.visitIfStatement(ctx);
    }

    @Override
    public Integer visitIndexing(SimplexParser.IndexingContext ctx) {

        return super.visitIndexing(ctx);
    }

    @Override
    public Integer visitInlineStatement(SimplexParser.InlineStatementContext ctx) {

        return super.visitInlineStatement(ctx);
    }

    @Override
    public Integer visitInteger(SimplexParser.IntegerContext ctx) {

        return super.visitInteger(ctx);
    }

    @Override
    public Integer visitLogicConjunction(SimplexParser.LogicConjunctionContext ctx) {

        return super.visitLogicConjunction(ctx);
    }

    @Override
    public Integer visitLogicDisjunction(SimplexParser.LogicDisjunctionContext ctx) {

        return super.visitLogicDisjunction(ctx);
    }

    @Override
    public Integer visitPrimary(SimplexParser.PrimaryContext ctx) {

        return super.visitPrimary(ctx);
    }

    @Override
    public Integer visitProgram(SimplexParser.ProgramContext ctx) {

        return super.visitProgram(ctx);
    }

    @Override
    public Integer visitReal(SimplexParser.RealContext ctx) {

        return super.visitReal(ctx);
    }

    @Override
    public Integer visitReturnStatement(SimplexParser.ReturnStatementContext ctx) {

        return super.visitReturnStatement(ctx);
    }

    @Override
    public Integer visitScope(SimplexParser.ScopeContext ctx) {
        String currentScope = getNextScopeName();
        scopeStack.push(currentScope);
        try {
            return super.visitScope(ctx);
        } finally {
            scopeStack.pop();
        }
    }

    private String getNextScopeName() {
        scopeCounter++;
        if (scopeStack.isEmpty()) {
            return scopeCounter.toString();
        } else {
            return scopeStack.peek() + "-" + scopeCounter;
        }
    }

    private String getCurrentScope() {
        if (!scopeStack.isEmpty()) {
            return scopeStack.peek();
        }
        return "global";
    }


    @Override
    public Integer visitSimpleFor(SimplexParser.SimpleForContext ctx) {

        return super.visitSimpleFor(ctx);
    }

    @Override
    public Integer visitSliceIndicator(SimplexParser.SliceIndicatorContext ctx) {

        return super.visitSliceIndicator(ctx);
    }

    @Override
    public Integer visitStatement(SimplexParser.StatementContext ctx) {

        return super.visitStatement(ctx);
    }

    @Override
    public Integer visitTerm(SimplexParser.TermContext ctx) {

        return super.visitTerm(ctx);
    }

    @Override
    public Integer visitTripleFor(SimplexParser.TripleForContext ctx) {

        return super.visitTripleFor(ctx);
    }

    @Override
    public Integer visitTypeExpression(SimplexParser.TypeExpressionContext ctx) {

        return super.visitTypeExpression(ctx);
    }

    @Override
    public Integer visitUnary(SimplexParser.UnaryContext ctx) {

        return super.visitUnary(ctx);
    }

    @Override
    public Integer visitVarAssignment(SimplexParser.VarAssignmentContext ctx) {

        return super.visitVarAssignment(ctx);
    }

    @Override
    public Integer visitVarDeclaration(SimplexParser.VarDeclarationContext ctx) {
        // TODO Auto-generated method stub

        String ctxText = ctx.getText();
        Integer childCount = ctx.getChildCount();
        //System.out.println("Text: " + ctxText + "\nChild Count: " + childCount.toString());

        ParseTree ids = ctx.getChild(0);
        String idsText = ids.getText();
        Integer idsCount = ids.getChildCount();

        ParseTree type = ctx.getChild(2);
        String typeText = type.getText();

        ParseTree expressions = null;
        Integer expressionsCount;
        String expressionsText;

        Boolean expressionsExist = (childCount == 5);

        if (expressionsExist) {
            expressions = ctx.getChild(4);
            expressionsCount = expressions.getChildCount();
            expressionsText = expressions.getText();

            if (idsCount != expressionsCount) {
                System.err.println(
                                    "The ids list size '" + idsText 
                                + "' is different from expressions list size " + expressionsText 
                                + "'");
                System.exit(1);
            }
        }

        Integer varsSize = idsCount;

        String currentScope = getCurrentScope();

        for (int i = 0; i < varsSize; i++) {
            if (i % 2 == 0) {
                String id = ids.getChild(i).getText();

                if (isVariableRedeclaredInScope(id, currentScope)) {
                    System.err.println("Error: Variable '" + id + "' already exists in scope '" + currentScope + "'");
                    System.exit(1);
                }

        
                Symbol symbol = new Symbol(id, typeText, expressionsExist, getCurrentScope());
                vars.add(symbol);
            }
        }

        // used;
        // param;
        // matrix;
        // ref;
        // func;

        return super.visitVarDeclaration(ctx);
    }

    private boolean isVariableRedeclaredInScope(String identifier, String scope) {
        for (Symbol symbol : vars) {
            if (symbol.getIdentifier().equals(identifier) && symbol.getScope().equals(scope)) {
                return true;
            }
        }
        return false;
    }


    @Override
    protected Integer aggregateResult(Integer aggregate, Integer nextResult) {

        return super.aggregateResult(aggregate, nextResult);
    }

    @Override
    protected Integer defaultResult() {

        return super.defaultResult();
    }

    @Override
    protected boolean shouldVisitNextChild(RuleNode node, Integer currentResult) {

        return super.shouldVisitNextChild(node, currentResult);
    }

    @Override
    public Integer visit(ParseTree tree) {
    
        return super.visit(tree);
    }

    @Override
    public Integer visitChildren(RuleNode arg0) {

        return super.visitChildren(arg0);
    }

    @Override
    public Integer visitErrorNode(ErrorNode node) {

        return super.visitErrorNode(node);
    }

    @Override
    public Integer visitTerminal(TerminalNode node) {

        return super.visitTerminal(node);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void finalize() throws Throwable {

        super.finalize();
    }
    

    public void printSymbols() {
        for(Symbol symbol : vars) {
            symbol.print();
        }
    }

}
