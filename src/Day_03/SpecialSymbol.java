package Day_03;

public enum SpecialSymbol {
    AT('@'),
    HASH('#'),
    DOLLAR('$'),
    PERCENT('%'),
    AMPERSAND('&'),
    ASTERISK('*'),
    PLUS('+'),
    EQUALS('='),
    MINUS('-'),
    SLASH('/');

    private final char symbol;

    SpecialSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static boolean isThisSymbol(char symbol) {
        for (SpecialSymbol special : SpecialSymbol.values()) {
            if(special.getSymbol() == symbol) {
                return true;
            }
        }
        return false;
    }
}
