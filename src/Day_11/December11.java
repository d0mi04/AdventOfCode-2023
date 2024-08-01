package Day_11;

import shared.DataSet;

public class December11 {
    public static void main (String[] args) {
        DataSet file = new DataSet("src/Day_11/input-11.txt");

        Navigator navigator = new Navigator(file);
        navigator.countDistance(navigator.galaxyMap);

    }
}
