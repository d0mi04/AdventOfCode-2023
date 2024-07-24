package Day_09;

import shared.DataSet;

import java.util.ArrayList;

public class Oasis {
    ArrayList<String> history;
    ArrayList<Sensor> sensors;

    public Oasis (DataSet file) {
        setHistory(file);
        setSensors();
    }

    public void setSensors() {
        sensors = new ArrayList<>();
        int sum = 0;
        for(String hist : history) {
            Sensor sensor = new Sensor(hist);
            sensors.add(sensor);
        }
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
