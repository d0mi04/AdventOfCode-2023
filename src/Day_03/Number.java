package Day_03;

import java.util.ArrayList;

public class Number {
    int value;
    int lineNumber;
    ArrayList<Integer> indexes;

    public Number(int value, int lineNumber, ArrayList<Integer> indexes) {
        this.value = value;
        this.lineNumber = lineNumber;
        this.indexes = indexes;
    }

    public void NumberUpdate(int value, ArrayList<Integer> indexes) {
        this.value = value;
        this.indexes = indexes;
    }
}
