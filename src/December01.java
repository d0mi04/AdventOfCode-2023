import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class December01 {
    public static void main(String[] args) {
        Lines lines = new Lines("src/input-01.txt");

        Part1(lines);
        Part2(lines);
    }

    public static void Part2 (Lines lines) {
        int sum = 0;
        for(String line : lines.lines) {
            Word word = new Word(line);
            sum += word.number;
        }

        System.out.printf("Sum2 of calibration values: %d\n", sum);
    }

    public static void Part1 (Lines lines) {
        int sum = 0;
        for(String line : lines.lines) {
            Number number = new Number(line);
            sum += number.number;
        }

        System.out.printf("Sum1 of calibration values: %d\n", sum);
    }
}
