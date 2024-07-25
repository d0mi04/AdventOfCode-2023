package Day_05;

public class December05 {

    public static void main (String[] args) {
        DataSet file = new DataSet("src/input-05.txt");

        Part1(file);

    }

    public static void Part1(DataSet file) {
        Garden garden = new Garden(file);
        garden.gardening();
        long minValue = garden.gardening();
        System.out.println("lowest location number is: " + minValue);
    }
}
