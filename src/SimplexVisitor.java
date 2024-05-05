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

    // @Override
    // public Integer visitScope(SimplexParser.ScopeContext ctx) {
    //     scopeStack.push(getNextScopeName());
    //     try {
    //         return super.visitScope(ctx);
    //     } finally {
    //         removeFromSymbol(getNextScopeName());
    //         scopeStack.pop();
    //     }
    // }

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
