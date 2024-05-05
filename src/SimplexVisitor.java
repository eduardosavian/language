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
    ArrayList<Symbol> vars_aux = new ArrayList<Symbol>();
    private Integer scopeCounter = 0;
    private Symbol var = null;
    private Deque<Symbol> symbolStack = new ArrayDeque<>();
    private Symbol varAux = null;

    @Override
    public Integer visitScope(SimplexParser.ScopeContext ctx) {
        scopeStack.push(getNextScopeName());
        try {
            return super.visitScope(ctx);
        } finally {
            removeFromSymbol(getNextScopeName());
            scopeStack.pop();
        }
    }

    private void removeFromSymbol(String scope) {
        List<Symbol> toRemove = new ArrayList<>();
        for (Symbol symbol : vars) {
            if (symbol.getScope().equals(scope)) {
                toRemove.add(symbol);
            }
        }
        vars.removeAll(toRemove);
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
        super.visitExpression(ctx);

        if (var != null) {
            var.setIsInitialized(true);
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
            System.err.println(
                    "Error: Variable '" + ctx.getText() + "' already exists in scope '" + getCurrentScope() + "'");
            System.exit(1);
        }

        if (var != null) {
            var.setIdentifier(ctx.ID(0).getText());
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
        var symbolAux = searchSymbol(ctx.ID().getText(), getCurrentScope());

        
        if (symbolAux != null) {
            symbolAux.setLessModifiers(ctx.SQUARE_OPEN().getText() + ctx.SQUARE_CLOSE().getText());
            
            symbolStack.push(symbolAux);
    
        } else {
            System.err.println("Error: Variable '" + ctx.ID().getText() + "' not declared in scope '"
                    + getCurrentScope() + "'");
            System.exit(1);
        }

        // super.visitIndexing(ctx);

        // for (Symbol symbol : symbolStack) {
        // }

        // symbolStack.pop();

        return null;
    }

    @Override
    public Integer visitInlineStatement(SimplexParser.InlineStatementContext ctx) {
        super.visitInlineStatement(ctx);

       
        for (Symbol symbol : symbolStack) {

            System.out.println("Symbol: " + symbol.getIdentifier() + " " + symbol.getType() + " " + symbol.getScope()
                    + " " + symbol.getModifiers());
            System.out.println("SymbolAux: " + vars.get(vars.size() - 1).getIdentifier() + " " + vars.get(vars.size() - 1).getType() + " " + vars.get(vars.size() - 1).getScope()
                    + " " + vars.get(vars.size() - 1).getModifiers());
            if (vars.get(vars.size() - 1).getType() != symbol.getType()) {
                System.err.println(
                        "Error: Variable '" + vars.get(vars.size() - 1).getIdentifier() + "' is not the same type");
                System.exit(1);
            }
            
            System.out.println(symbol.getModifiers().equals(vars.get(vars.size() - 1).getModifiers()));
            if (!symbol.getModifiers().equals(vars.get(vars.size() - 1).getModifiers())) {
                System.err.println("Error: Variable '" + vars.get(vars.size() - 1).getIdentifier() + "' is [] not equal");
                System.exit(1);
                
            }
        }

        return null;
    }

    @Override
    public Integer visitInteger(SimplexParser.IntegerContext ctx) {
        varAux = new Symbol(getCurrentScope());
        if (ctx.LITERAL_BIN() != null) {
            varAux.setIdentifier(ctx.getText());
            varAux.setType("int");
        } else if (ctx.LITERAL_INT() != null) {
            varAux.setIdentifier(ctx.getText());
            varAux.setType("int");
        } else if (ctx.LITERAL_HEX() != null) {
            varAux.setIdentifier(ctx.getText());
            varAux.setType("int");
        }

        symbolStack.push(varAux);

        return super.visitInteger(ctx);
    }

    @Override
    public Integer visitReal(SimplexParser.RealContext ctx) {
        varAux = new Symbol(getCurrentScope());
        if (ctx.LITERAL_FLOAT() != null) {
            varAux.setIdentifier(ctx.getText());
            varAux.setType("real");
        }
        symbolStack.push(varAux);

        return super.visitReal(ctx);
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

        varAux = new Symbol(getCurrentScope());


        if (ctx != null) {
            if (ctx.ID() != null) {
                if (!isDeclared(ctx.ID().getText(), getCurrentScope())) {
                    System.err.println("Error: Variable '" + ctx.ID().getText() + "' not declared in scope '"
                            + getCurrentScope() + "'");
                    System.exit(1);
                }

                Symbol symbol_aux = searchSymbol(ctx.ID().getText(), getCurrentScope());

                //vars_aux.add(symbol_aux);
                //symbolStack.push(varAux);
            } else if (ctx.LITERAL_RUNE() != null) {
                System.out.println("Rune " + ctx.getText());
                //symbolStack.push(varAux);
            } else if (ctx.LITERAL_STRING() != null) {
                varAux.setIdentifier(ctx.getText());
                varAux.setType("string");
                //symbolStack.push(varAux);
            } else if (ctx.NIL() != null) {
                System.out.println("Null " + ctx.getText());

                //symbolStack.push(varAux);
            }

        }

        return super.visitPrimary(ctx);
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
        if (var != null) {
            var.setType(ctx.getText());
        }

        return super.visitTypeExpression(ctx);
    }

    @Override
    public Integer visitUnary(SimplexParser.UnaryContext ctx) {
        return super.visitUnary(ctx);
    }

    @Override
    public Integer visitVarAssignment(SimplexParser.VarAssignmentContext ctx) {

        super.visitVarAssignment(ctx);

        return null;
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

    private Symbol searchSymbol(String identifier, String scope) {
        for (Symbol symbol : vars) {
            if (symbol.getIdentifier().equals(identifier) && scope.contains(symbol.getScope())) {
                return new Symbol(symbol);
            }
        }
        return null;
    }

    public void printSymbols() {
        for (Symbol symbol : vars) {
            symbol.print();
        }
    }

    public void PrintSymbolsAux() {
        for (Symbol symbol : symbolStack) {
            symbol.print();
        }
    }

}
