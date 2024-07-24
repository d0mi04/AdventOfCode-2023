package Day_09;

import java.util.ArrayList;
import java.util.LinkedList;

public class Sensor {
    ArrayList<Integer> sensor;
    ArrayList<ArrayList<Integer>> predictionProcess;

    public Sensor (String line) {
        setSensor(line);
    }

    // part 2:
    public int BackwardsPredictions () {
        predictionProcess.getLast().addFirst(0);
        int prediction = 0;
        for(int i = predictionProcess.size() - 1; i > 0; i--) {
            ArrayList<Integer> currentSensor = predictionProcess.get(i);
            ArrayList<Integer> previousSensor = predictionProcess.get(i - 1);

            prediction = previousSensor.getFirst() - currentSensor.getFirst();
            previousSensor.addFirst(prediction);
        }

        return prediction;
    }


    // part 1:
    public int findPredictions () {
        predictionProcess.getLast().add(0);
        int prediction = 0;
        for(int i = predictionProcess.size() - 1; i > 0; i--) {
            ArrayList<Integer> currentSensor = predictionProcess.get(i);
            ArrayList<Integer> previousSensor = predictionProcess.get(i - 1);

            prediction = previousSensor.getLast() + currentSensor.getLast();
//            System.out.println("prediction sum: " + previousSensor.getLast() + " " + currentSensor.getLast());
            previousSensor.add(prediction);
//            System.out.println("Prediction: " + previousSensor.getLast());
        }
        return prediction;
    }

    public boolean allZeros(ArrayList<Integer> nextLine) {
        for(int value : nextLine) {
            if(value != 0) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> createNextSensor(ArrayList<Integer> sensor) {
        ArrayList<Integer> nextSensor = new ArrayList<>();

        for(int i = 0; i < sensor.size() - 1; i++) {
            nextSensor.add(sensor.get(i + 1) - sensor.get(i));
        }

        return nextSensor;
    }

    public void setPredictionProcess () {
        predictionProcess = new ArrayList<>();
        predictionProcess.add(sensor);

        while(true) {
            ArrayList<Integer> lastLine = predictionProcess.getLast();
            ArrayList<Integer> nextLine = createNextSensor(lastLine);

            if(allZeros(nextLine)) {
                predictionProcess.add(nextLine);
                break;
            } else {
                predictionProcess.add(nextLine);
            }
        }

//        System.out.println("Sensors: ");
//        for(ArrayList<Integer> sensor : predictionProcess) {
//            System.out.println("differences: ");
//            for(Integer val : sensor) {
//                System.out.print(val + " ");
//            }
//            System.out.println();
//        }
    }

    public void setSensor (String line) {
        sensor = new ArrayList<>();
        String[] split = line.split(" ");
        for(String s : split) {
            sensor.add(Integer.parseInt(s));
        }

//        System.out.print("Sensor values: ");
//        for(Integer val : sensor) {
//            System.out.print(val + " ");
//        }
//        System.out.println();
    }
}
