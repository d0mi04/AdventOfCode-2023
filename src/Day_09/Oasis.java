package Day_09;

import shared.DataSet;

import java.util.ArrayList;

public class Oasis {
    ArrayList<String> history;

    public Oasis (DataSet file) {
        setHistory(file);
    }

    public void countPredictions() {
        ArrayList<Sensor> sensors = new ArrayList<>();
        int sum = 0;
        for(String hist : history) {
            Sensor sensor = new Sensor(hist);
            sensors.add(sensor);
        }

        for(Sensor sensor : sensors) {
            sensor.setPredictionProcess();
            sum += sensor.findPredictions();
//            System.out.println(sensor.findPredictions());
        }

        System.out.println(sum);
    }

    public void setHistory (DataSet file) {
        history = new ArrayList<>();
        history.addAll(file.getLines());
//
//        for(String line : history) {
//            System.out.println(line);
//        }
    }
}
