package Day_01;

import shared.DataSet;

public class December01 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/Day_01/input-01.txt");

        Part1(file);
        Part2(file);
    }

    public static void Part2 (DataSet file) {
        int sum = 0;
        for(String line : file.getLines()) {
            Word word = new Word(line);
            sum += word.number;
        }

        System.out.printf("Sum2 of calibration values: %d\n", sum);
    }

    public static void Part1 (DataSet file) {
        int sum = 0;
        for(String line : file.getLines()) {
            Number number = new Number(line);
            sum += number.number;
        }

        System.out.printf("Sum1 of calibration values: %d\n", sum);
    }
}
