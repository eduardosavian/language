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

    Symbol(String Scope) {
        this.identifier = "";
        this.type = Symbol.Type.REAL ;
        this.isInitialized = false;
        this.used = false;
        this.scope = Scope;
        this.isParameter = false;
        this.isFunction = false;
    }

    public Symbol(Symbol another) {
        this.identifier = another.identifier;
        this.type = another.type;
        this.isInitialized = another.isInitialized;
        this.used = another.used;
        this.scope = another.scope;
        this.modifiers = another.modifiers;
        this.isParameter = another.isParameter;
        this.isFunction = another.isFunction;
    }
    
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getType() {
        return this.type.getType();
    }

    public void setType(String type) {
        for (Type t : Type.values()) {
            if (type.contains(t.getType())) {
                this.type = t;
                return;
            }
        }

        System.out.println("Error: Invalid type '" + type + "'");
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

    
    public void setIsInitialized(Boolean isInitialized) {
        this.isInitialized = isInitialized;
    }

    public String getModifiers() {
        return modifiers;
    }

    public void setModifiers(String modifiers) {
        this.modifiers += modifiers;
    }

    public void setLessModifiers(String modifiers) {
        System.out.println("Modifiers: " + this.modifiers + " | Less: " + modifiers);
       
        this.modifiers = this.modifiers.substring(0, this.modifiers.length() - modifiers.length());
        System.out.println(this.modifiers);
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
