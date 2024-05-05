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
    private Integer scopeCounter = 0;
    private Deque<String> operationStack = new ArrayDeque<>();
    private Deque<Symbol> declarationStack = new ArrayDeque<>();


    ArrayList<Symbol> vars = new ArrayList<Symbol>();
    Symbol var = null;

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
    public Integer visitExpression(SimplexParser.ExpressionContext ctx) {
        // TODO Auto-generated method stub
        return super.visitExpression(ctx);
    }



    @Override
    public Integer visitExpressionList(SimplexParser.ExpressionListContext ctx) {
        super.visitExpressionList(ctx);
        
        for (String name : operationStack) {
            System.out.println(name);
        }
        
        operationStack.clear();

        return 1;
    }

    

    @Override
    public Integer visitBitShift(SimplexParser.BitShiftContext ctx) {
        
        if(ctx.SHIFT_LEFT() != null){
            operationStack.push("<<");
        } else if(ctx.SHIFT_RIGHT() != null){
            operationStack.push(">>");
        }
        return super.visitBitShift(ctx);
    }

    @Override
    public Integer visitComparison(SimplexParser.ComparisonContext ctx) {
        if(ctx.EQ_EQ() != null){
            operationStack.push("==");
        } else if(ctx.NOT_EQ() != null){
            operationStack.push("!=");
        } else if(ctx.GT() != null){
            operationStack.push(">");
        } else if(ctx.GT_EQ() != null){
            operationStack.push(">=");
        } else if(ctx.LT() != null){
            operationStack.push("<");
        } else if(ctx.LT_EQ() != null){
            operationStack.push("<=");
        }
        return super.visitComparison(ctx);
    }

    @Override
    public Integer visitFactor(SimplexParser.FactorContext ctx) {
        System.out.println(ctx.getText());
        System.out.println(ctx.MOD() != null);
        if(ctx.MOD() != null) {
            operationStack.push("%");
        } else if(ctx.SLASH() != null) {
            operationStack.push("/");
        } else if(ctx.STAR() != null) {
            operationStack.push("*");
        } else if(ctx.AND() != null) {
            operationStack.push("+");
        }
        return super.visitFactor(ctx);
    }


    @Override
    public Integer visitUnary(SimplexParser.UnaryContext ctx) {
        if(ctx.MINUS() != null) {
            operationStack.push("-");
        } else if(ctx.PLUS()  != null) {
            operationStack.push("+");
        } else if(ctx.XOR() != null) {
            operationStack.push("!");
        } else if (ctx.LOGIC_NOT() != null){
            
        }
        return super.visitUnary(ctx);
    }
    

    @Override
    public Integer visitTerm(SimplexParser.TermContext ctx) {
        if(ctx.PLUS() != null) {
            operationStack.push("+");
        } else if(ctx.MINUS() != null) {
            operationStack.push("-");
        } else if(ctx.OR() != null) {
            operationStack.push("||");
        } else if(ctx.XOR() != null) {
            operationStack.push("~");
        }
        return super.visitTerm(ctx);
    }

    @Override
    public Integer visitLogicConjunction(SimplexParser.LogicConjunctionContext ctx) {
        if (ctx.LOGIC_AND() != null) {
            operationStack.push("&&");
        }
        return super.visitLogicConjunction(ctx);
    }

    @Override
    public Integer visitLogicDisjunction(SimplexParser.LogicDisjunctionContext ctx) {
        if(ctx.LOGIC_OR() != null){
            operationStack.push("||");
        } else if(ctx.LOGIC_XOR() != null){
            operationStack.push("^^");
        }
        return super.visitLogicDisjunction(ctx);
    }

    @Override
    public Integer visitInlineStatement(SimplexParser.InlineStatementContext ctx) {
        super.visitInlineStatement(ctx);

        return 1;
    }

    @Override
    public Integer visitInteger(SimplexParser.IntegerContext ctx) {
        if(ctx.LITERAL_BIN() != null){
            var.setType("int");
        } else if(ctx.LITERAL_INT() != null){
            var.setType("int");
        } else if(ctx.LITERAL_HEX() != null){
            var.setType("int");
        }

        operationStack.push("int");

        return super.visitInteger(ctx);
    }

    @Override
    public Integer visitPrimary(SimplexParser.PrimaryContext ctx) {
        if(ctx.ID() != null){
            operationStack.push(searchSymbol(ctx.ID().getText(), getCurrentScope()).getType());
        } else if(ctx.LITERAL_RUNE() != null){
            operationStack.push("rune");
        } else if (ctx.LITERAL_STRING() != null) {
            operationStack.push("string");
        } else if(ctx.NULL() != null) {
            operationStack.push("null");
        } else if (ctx.FALSE() != null) {
            operationStack.push("bool");
        } else if(ctx.TRUE() != null) {
            operationStack.push("bool");
        }
        
        return super.visitPrimary(ctx);
    }

    @Override
    public Integer visitReal(SimplexParser.RealContext ctx) {
        if (ctx.LITERAL_REAL() != null) {
            var.setType("real");
        }

        operationStack.push("real");
        return super.visitReal(ctx);
    }


    @Override
    public Integer visitIdentifierList(SimplexParser.IdentifierListContext ctx) {
        
        return super.visitIdentifierList(ctx);
    }

    

    @Override
    public Integer visitIdentifier(SimplexParser.IdentifierContext ctx) {
        var = searchSymbol(ctx.ID().getText(), getCurrentScope());
        if (var != null) {
            System.err.println("Error: Variable '" + ctx.ID().getText() + "' declared in scope '" + getCurrentScope() + "'");
            System.exit(1);
        } else {
            var = new Symbol(getCurrentScope());
            var.setIdentifier(ctx.ID().getText());
        }

        declarationStack.push(var);
        return super.visitIdentifier(ctx);
    }

    @Override
    public Integer visitSliceIndicator(SimplexParser.SliceIndicatorContext ctx) {
        for(Symbol symbol : declarationStack){
            symbol.setMoreModifiers(ctx.SQUARE_OPEN().getText() + ctx.SQUARE_CLOSE().getText());
        }
        return super.visitSliceIndicator(ctx);
    }

    @Override
    public Integer visitTypeExpression(SimplexParser.TypeExpressionContext ctx) {
        for(Symbol symbol : declarationStack){
            symbol.setType(ctx.getText());
        }
        
        return super.visitTypeExpression(ctx);
    }

    @Override
    public Integer visitVarDeclaration(SimplexParser.VarDeclarationContext ctx) {
        var = new Symbol(getCurrentScope());

        super.visitVarDeclaration(ctx);


        for (Symbol symbol : declarationStack) {
            vars.add(symbol);
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

}
