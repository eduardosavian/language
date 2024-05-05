public class Symbol {
    public enum Type {
        INT("int"),
        REAL("real"),
        BOOL("bool"),
        STRING("string");

        private final String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private String identifier = "";
    private Type type;
    private Boolean isInitialized = false;
    private Boolean used = false;
    private String scope = "";
    private String modifiers = "";
    private Boolean isParameter = false;
    private Boolean isFunction = false;

    Symbol(String identifier, String type, Boolean expressionsExist, String Scope) {
        this.identifier = identifier;

        Boolean typeExists = false;

        for (Type typeSymbol : Type.values()) {
            if (type.contains(typeSymbol.getType())) {
                this.type = typeSymbol;
                this.modifiers = type.replace(typeSymbol.getType(), "");
                typeExists = true;
                break;
            }
        }

        if (!typeExists) {
            System.err.println(
                    "The id '" + identifier
                            + type + "' type doesn't exist");
            System.exit(1);
        }

        this.isInitialized = expressionsExist;
        
        this.used = false;
        this.scope = Scope;
        this.isParameter = false;
        this.isFunction = false;

    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Boolean getIsInitialized() {
        return isInitialized;
    }

    public void setISInitialized(Boolean initialized) {
        this.isInitialized = initialized;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String Scope) {
        this.scope = Scope;
    }

    public Boolean getIsParameter() {
        return isParameter;
    }

    public void setIsParameter(Boolean isParameter) {
        this.isParameter = isParameter;
    }

    public Boolean getIsFunction() {
        return isFunction;
    }

    public void setIsFunction(Boolean isFunction) {
        this.isFunction = isFunction;
    }

    
    public void print() {
        System.out.print("Identifier: " + identifier);
        System.out.print(" | ");
        System.out.print("Type: " + type.getType());
        System.out.print(" | ");
        System.out.print("Modifiers: " + modifiers);
        System.out.print(" | ");
        System.out.print("Initialized: " + isInitialized);
        System.out.print(" | ");
        System.out.print("Used: " + used);
        System.out.print(" | ");
        System.out.print("Scope: " + scope);
        System.out.print(" | ");
        System.out.print("Parameter: " + isParameter);
        System.out.print(" | ");
        System.out.println("Function: " + isFunction);
    }

}
