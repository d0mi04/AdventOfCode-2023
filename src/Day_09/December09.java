package Day_09;

import shared.DataSet;

import java.util.ArrayList;

public class December09 {
    public static void main(String[] args ) {
        DataSet file = new DataSet("src/Day_09/input-09.txt");

        Part1(file);
        Part2(file);
    }

    public static void Part2(DataSet file) {
        Oasis oasis = new Oasis(file);
        int sum = 0;
        for(Sensor sensor : oasis.sensors) {
            sensor.setPredictionProcess();
            sum += sensor.BackwardsPredictions();
        }
        System.out.printf("Sum of all extrapoated values is: %d\n", sum);
    }

    public static void Part1(DataSet file) {
        Oasis oasis = new Oasis(file);
        int sum = 0;
        for(Sensor sensor : oasis.sensors) {
            sensor.setPredictionProcess();
            sum += sensor.findPredictions();
        }
        System.out.printf("Sum of all extrapoated values is: %d\n", sum);
    }
}
