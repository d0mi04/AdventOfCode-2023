package Day_09;

import shared.DataSet;

import java.util.ArrayList;

public class Oasis {
    ArrayList<Sensor> listOfSensors;
    ArrayList<Integer> predictions;

    public Oasis (DataSet file) {
        setListOfSensors(file);
    }

    public void setListOfSensors(DataSet file) {
        listOfSensors = new ArrayList<>();
        for(String line : file.getLines()) {
            listOfSensors.add(new Sensor(line));
        }
    }
}
