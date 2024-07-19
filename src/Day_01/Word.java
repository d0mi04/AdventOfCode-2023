package Day_01;

import java.util.HashMap;
import java.util.Map;

public class Word {
    HashMap<String, String> MapOfNumbers;
    int number;

    public Word(String line) {
        this.MapOfNumbers = createNumbersMap();
        this.number = findNumber(line);
    }

    public int findNumber (String line) {
        HashMap<String, Integer> FirstDigitIndexMap = mappingFirstIndex(line);
        HashMap<String, Integer> LastDigitIndexMap = mappingLastIndex(line);
        int lowestIndex = Integer.MAX_VALUE;
        String firstDigit = "";

        int highestIndex = Integer.MIN_VALUE;
        String lastDigit = "";

        for(String number : FirstDigitIndexMap.keySet()) {
            if (FirstDigitIndexMap.get(number) < lowestIndex) {
                firstDigit = number;
                lowestIndex = FirstDigitIndexMap.get(number);
            }
        }
        for(String number : LastDigitIndexMap.keySet()) {
            if(LastDigitIndexMap.get(number) > highestIndex) {
                lastDigit = number;
                highestIndex = LastDigitIndexMap.get(number);
//                System.out.println(highestIndex);
            }
        }

        if(firstDigit.length() != 1) {
            firstDigit = MapOfNumbers.get(firstDigit);
        }
        if(lastDigit.length() != 1) {
            lastDigit = MapOfNumbers.get(lastDigit);
        }

//        System.out.println(firstDigit+lastDigit);
        return createNumber(firstDigit, lastDigit);
    }

    public HashMap<String, Integer> mappingLastIndex (String line) {
        HashMap<String, Integer> IndexMap = new HashMap<>();
        for(String word : MapOfNumbers.keySet()) {
            int index = line.lastIndexOf(word);
            if(index != -1) {
                IndexMap.put(word, index);
            }
        }

        for(String digit : MapOfNumbers.values()) {
            int index = line.lastIndexOf(digit);
            if(index != -1) {
                IndexMap.put(digit, index);
            }
        }
        return IndexMap;
    }

    public HashMap<String, Integer> mappingFirstIndex (String line) {
        HashMap<String, Integer> IndexMap = new HashMap<>();
        for(String word : MapOfNumbers.keySet()) {
            int index = line.indexOf(word);
            if(index != -1) {
                IndexMap.put(word, index);
            }
        }

        for(String digit : MapOfNumbers.values()) {
            int index = line.indexOf(digit);
            if(index != -1) {
                IndexMap.put(digit, index);
            }
        }
        return IndexMap;
    }

    public int createNumber (String firstDigit, String lastDigit) {
        return Integer.parseInt(firstDigit+lastDigit);
    }

    public HashMap<String, String> createNumbersMap () {
        HashMap<String, String> MapOfNumbers = new HashMap<>();
        // HashMap: klucz, wartość
        MapOfNumbers.put("one", "1");
        MapOfNumbers.put("two", "2");
        MapOfNumbers.put("three", "3");
        MapOfNumbers.put("four", "4");
        MapOfNumbers.put("five", "5");
        MapOfNumbers.put("six", "6");
        MapOfNumbers.put("seven", "7");
        MapOfNumbers.put("eight", "8");
        MapOfNumbers.put("nine", "9");

        return MapOfNumbers;
    }
}

