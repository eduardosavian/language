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
    public Integer visitInteger(SimplexParser.IntegerContext ctx) {
        if(ctx.LITERAL_BIN() != null){
            System.out.println("Literal Bin: " + ctx.LITERAL_BIN().getText());
        } else if(ctx.LITERAL_INT() != null){
            System.out.println("Literal Int: " + ctx.LITERAL_INT().getText());
        } else if(ctx.LITERAL_HEX() != null){
            System.out.println("Literal Hex: " + ctx.LITERAL_HEX().getText());
        }
        return super.visitInteger(ctx);
    }

    @Override
    public Integer visitPrimary(SimplexParser.PrimaryContext ctx) {
        if(ctx.ID() != null){
            System.out.println("Identifier: " + ctx.ID().getText());
            var.setIdentifier(ctx.ID().getText());
        } else if(ctx.LITERAL_RUNE() != null){
            System.out.println("Literal Rune: " + ctx.LITERAL_RUNE().getText());
        } else if (ctx.LITERAL_STRING() != null) {
            System.out.println("Literal String: " + ctx.LITERAL_STRING().getText());
        }
        return super.visitPrimary(ctx);
    }

    @Override
    public Integer visitReal(SimplexParser.RealContext ctx) {
        // TODO Auto-generated method stub
        return super.visitReal(ctx);
    }

    @Override
    public Integer visitUnary(SimplexParser.UnaryContext ctx) {
        // TODO Auto-generated method stub
        return super.visitUnary(ctx);
    }

    @Override
    public Integer visitIdentifierList(SimplexParser.IdentifierListContext ctx) {
        var.setIdentifier(ctx.getText());
        
        return super.visitIdentifierList(ctx);
    }

    

    @Override
    public Integer visitSliceIndicator(SimplexParser.SliceIndicatorContext ctx) {
        var.setMoreModifiers(ctx.SQUARE_OPEN().getText() + ctx.SQUARE_CLOSE().getText());
        return super.visitSliceIndicator(ctx);
    }

    @Override
    public Integer visitTypeExpression(SimplexParser.TypeExpressionContext ctx) {
        
        return super.visitTypeExpression(ctx);
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

}
