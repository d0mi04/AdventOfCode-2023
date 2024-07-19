package Day_08;

import shared.DataSet;

public class December08 {

    public static void main (String[] args) {
        DataSet file = new DataSet("src/Day_08/input-08.txt");

        Part1(file);

    }

    public static void Part1(DataSet file) {
        Map map = new Map(file);
        int steps = 0;
        steps = map.move();
        System.out.printf("Exit found in steps: %d\n", steps);
    }
}
