package Day_10;

import shared.DataSet;

import java.util.ArrayList;

public class December10 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/Day_10/input-10.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        Navigator navigator = new Navigator();
        ArrayList<String> input = file.getLines();
        System.out.println(navigator.findFarthestPipe(input));
    }
}
