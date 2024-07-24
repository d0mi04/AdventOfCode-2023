package Day_03;

import java.util.ArrayList;

public class December03 {

    public static void main (String[] args) {
        DataSet file = new DataSet("src/test.txt");
        Engine en = new Engine();

        for(int s = 0; s < file.lines.size(); s++) {
            String line = file.lines.get(s);
            en.fillArrays(line, s);
        }

        Part1(en);
        Part2(en);
    }

    public static boolean isNearby(Symbol symbol, int lineNumber, int index) {
        int lineDiff = Math.abs(symbol.lineNumber - lineNumber);
        int indexDiff = Math.abs(symbol.index - index);

        boolean isAdjacent = (lineDiff == 0 && indexDiff <= 1) ||
                (lineDiff == 1 && indexDiff <= 1);
        boolean isMiddleAdjacent = lineDiff == 1 && (symbol.index == index - 1 ||
                symbol.index == index + 1);

        return isAdjacent || isMiddleAdjacent;
    }

    public static void Part2 (Engine en) {
        int sum = 0;
        for(Symbol symbol : en.symbols) {
            if(symbol.symbol == '*') {
                ArrayList<Integer> powerNumbers = new ArrayList<>();

                for(Number number : en.numbers) {
                        for(Integer index : number.indexes) {
                            if(isNearby(symbol, number.lineNumber, index)) {
                                powerNumbers.add(number.value);
                            }
                        }
                }

                if(powerNumbers.size() == 2) {
                    sum += powerNumbers.get(0)*powerNumbers.get(1);
                    System.out.println(powerNumbers.get(0) + " " + powerNumbers.get(1));
                }
            }
        }

        System.out.printf("Sum of powers: %d\n", sum);
    }

    public static void Part1 (Engine en) {
        int sum = 0;
        for(Number number : en.numbers) {
            for(Symbol symbol : en.symbols) {
                if(number.lineNumber == symbol.lineNumber ||
                    number.lineNumber == symbol.lineNumber - 1 ||
                    number.lineNumber == symbol.lineNumber + 1) {

                    for(Integer index : number.indexes) {
                        if(Math.abs(index - symbol.index) <= 1) {
                            System.out.println(number.value);
                            sum += number.value;
//                            number.value = 0;
                            break;
                        }
                    }
                }
            }
        }

        System.out.printf("Sum of numbers: %d\n", sum);
    }
}
