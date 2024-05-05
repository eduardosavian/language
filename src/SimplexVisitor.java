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
    private Symbol var = null;
    private Deque<String> expressionStack = new ArrayDeque<>();


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
    public Integer visitBitShift(SimplexParser.BitShiftContext ctx) {
        // TODO Auto-generated method stub
        return super.visitBitShift(ctx);
    }

    @Override
    public Integer visitBreakStatement(SimplexParser.BreakStatementContext ctx) {
        // TODO Auto-generated method stub
        return super.visitBreakStatement(ctx);
    }

    @Override
    public Integer visitComparison(SimplexParser.ComparisonContext ctx) {
        return super.visitComparison(ctx);
    }

    @Override
    public Integer visitContinueStatement(SimplexParser.ContinueStatementContext ctx) {
        // TODO Auto-generated method stub
        return super.visitContinueStatement(ctx);
    }

    @Override
    public Integer visitDoFor(SimplexParser.DoForContext ctx) {
        // TODO Auto-generated method stub
        return super.visitDoFor(ctx);
    }

    @Override
    public Integer visitExprStatement(SimplexParser.ExprStatementContext ctx) {
        // TODO Auto-generated method stub
        return super.visitExprStatement(ctx);
    }

    @Override
    public Integer visitExpression(SimplexParser.ExpressionContext ctx) {
        if (var != null) {
            var.setIsInitialized(true);
        }

        super.visitExpression(ctx);

        for (String expression : expressionStack) {
            System.out.println(expression);
        }

        return null;
    }

    @Override
    public Integer visitExpressionList(SimplexParser.ExpressionListContext ctx) {
        // TODO Auto-generated method stub
        return super.visitExpressionList(ctx);
    }

    @Override
    public Integer visitFactor(SimplexParser.FactorContext ctx) {
        return super.visitFactor(ctx);
    }

    @Override
    public Integer visitField(SimplexParser.FieldContext ctx) {
        // TODO Auto-generated method stub
        return super.visitField(ctx);
    }

    @Override
    public Integer visitFieldList(SimplexParser.FieldListContext ctx) {
        // TODO Auto-generated method stub
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

    @Override
    public Integer visitIdentifierList(SimplexParser.IdentifierListContext ctx) {

        if (isDeclared(ctx.getText(), getCurrentScope())) {
            System.err.println("Error: Variable '" + ctx.getText() + "' already exists in scope '" + getCurrentScope() + "'");
            System.exit(1);
        }

        if (var != null) {
            var.setIdentifier(ctx.getText());
        }

        return super.visitIdentifierList(ctx);
    }

    private Boolean isDeclared(String identifier, String currentScope) {
        for (Symbol symbol : vars) {
            if (symbol.getIdentifier().equals(identifier) && currentScope.contains(symbol.getScope())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer visitIfStatement(SimplexParser.IfStatementContext ctx) {
        // TODO Auto-generated method stub
        return super.visitIfStatement(ctx);
    }

    @Override
    public Integer visitIndexing(SimplexParser.IndexingContext ctx) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return super.visitPrimary(ctx);
    }

    @Override
    public Integer visitProgram(SimplexParser.ProgramContext ctx) {
        // TODO Auto-generated method stub
        return super.visitProgram(ctx);
    }

    @Override
    public Integer visitReal(SimplexParser.RealContext ctx) {
        // TODO Auto-generated method stub
        return super.visitReal(ctx);
    }

    @Override
    public Integer visitReturnStatement(SimplexParser.ReturnStatementContext ctx) {
        // TODO Auto-generated method stub
        return super.visitReturnStatement(ctx);
    }

    @Override
    public Integer visitSimpleFor(SimplexParser.SimpleForContext ctx) {
        // TODO Auto-generated method stub
        return super.visitSimpleFor(ctx);
    }

    @Override
    public Integer visitSliceIndicator(SimplexParser.SliceIndicatorContext ctx) {
        var.setModifiers(ctx.getText());
        return super.visitSliceIndicator(ctx);
    }

    @Override
    public Integer visitStatement(SimplexParser.StatementContext ctx) {
        // TODO Auto-generated method stub
        return super.visitStatement(ctx);
    }

    @Override
    public Integer visitTerm(SimplexParser.TermContext ctx) {
        // TODO Auto-generated method stub
        return super.visitTerm(ctx);
    }

    @Override
    public Integer visitTripleFor(SimplexParser.TripleForContext ctx) {
        // TODO Auto-generated method stub
        return super.visitTripleFor(ctx);
    }

    @Override
    public Integer visitTypeExpression(SimplexParser.TypeExpressionContext ctx) {
        
        return super.visitTypeExpression(ctx);
    }

    

    @Override
    public Integer visitTypeEstablishment(SimplexParser.TypeEstablishmentContext ctx) {
        if (var != null) {
            var.setType(ctx.getText());
        }
        return super.visitTypeEstablishment(ctx);
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
        var = new Symbol(getCurrentScope());
        
        super.visitVarDeclaration(ctx);
        
        if (var != null) {
            vars.add(var);
            var = null;
        }


        return null;
    }

    @Override
    protected Integer aggregateResult(Integer aggregate, Integer nextResult) {
        // TODO Auto-generated method stub
        return super.aggregateResult(aggregate, nextResult);
    }

    @Override
    protected Integer defaultResult() {
        // TODO Auto-generated method stub
        return super.defaultResult();
    }

    @Override
    protected boolean shouldVisitNextChild(RuleNode node, Integer currentResult) {
        // TODO Auto-generated method stub
        return super.shouldVisitNextChild(node, currentResult);
    }

    @Override
    public Integer visit(ParseTree tree) {
        // TODO Auto-generated method stub
        return super.visit(tree);
    }

    @Override
    public Integer visitChildren(RuleNode arg0) {
        // TODO Auto-generated method stub
        return super.visitChildren(arg0);
    }

    @Override
    public Integer visitErrorNode(ErrorNode node) {
        // TODO Auto-generated method stub
        return super.visitErrorNode(node);
    }

    @Override
    public Integer visitTerminal(TerminalNode node) {
        // TODO Auto-generated method stub
        return super.visitTerminal(node);
    }

    public void printSymbols() {
        for (Symbol symbol : vars) {
            symbol.print();
        }
    }

}
