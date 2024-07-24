package Day_09;

import shared.DataSet;

public class December09 {
    public static void main(String[] args ) {
        DataSet file = new DataSet("src/Day_09/input-09.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        Oasis oasis = new Oasis(file);
        oasis.countPredictions();
    }
}
