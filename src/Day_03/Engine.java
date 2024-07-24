package Day_03;

import java.util.ArrayList;

public class Engine {

    ArrayList<Number> numbers;
    ArrayList<Symbol> symbols;

    public Engine() {
        this.numbers = new ArrayList<>();
        this.symbols = new ArrayList<>();
    }

    public void fillArrays(String line, int lineNumber) {

        for (int i = 0; i < line.length() - 1; i++) {
            // fill symbol ArrayList
            if (SpecialSymbol.isThisSymbol(line.charAt(i))) {
                Symbol symbol = new Symbol(line.charAt(i), lineNumber, i);
                this.symbols.add(symbol);
//                System.out.println("sym: " + symbol.symbol + " line: " + symbol.lineNumber + " index: " + symbol.index);
            }

            // fill number ArrayList
            if (Character.isDigit(line.charAt(i))) {
                String firstDigit = Character.toString(line.charAt(i));
                ArrayList<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                Number nr = new Number(Integer.parseInt(firstDigit), lineNumber, indexes);

                while (Character.isDigit(line.charAt(i + 1)) && i + 1 < line.length() - 1) {
                    String nextDigit = Character.toString(line.charAt(i + 1));
                    int value = Integer.parseInt(firstDigit + nextDigit);
                    firstDigit = Integer.toString(value);

                    indexes.add(i + 1);
                    nr.NumberUpdate(value, indexes);

                    i++;
                }

                this.numbers.add(nr);
            }
        }
    }
}