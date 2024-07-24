package Day_09;

import java.util.ArrayList;

public class Sensor {
    ArrayList<Integer> inputSensor;
    ArrayList<Node> differenceSensor;

    public Sensor (String line) {
        setInputSensor(line);
    }

    public void setSensor() {
        differenceSensor = new ArrayList<>();
        for(int i = 0; i < inputSensor.size() - 1; i++) {
            int previous = inputSensor.get(i);
            int next = inputSensor.get(i + 1);
            int difference = next - previous;
            differenceSensor.add(new Node(previous, next, difference));
        }
    }

    public void setInputSensor (String line) {
        inputSensor = new ArrayList<>();
        String[] split = line.split("\\s+");
        for(String s : split) {
            inputSensor.add(Integer.parseInt(s));
        }
    }
}
