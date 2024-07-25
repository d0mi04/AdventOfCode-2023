package Day05;

import java.util.ArrayList;

public class CorrespondingMap {
    ArrayList<Long> sourceStart;
    ArrayList<Long> destinationStart;
    ArrayList<Long> range;

    public CorrespondingMap(String line) {
        setNumbers(line);
    }


    public void setNumbers (String line) {
        destinationStart = new ArrayList<>();
        sourceStart = new ArrayList<>();
        range = new ArrayList<>();
        String[] numbers = line.split(":")[1].split("\\s+");

        ArrayList<String> AllNumbers = new ArrayList<>();
        for(String num : numbers) {
            if(!num.isEmpty()) {
                AllNumbers.add(num);
            }
        }

        for(int i = 0; i < AllNumbers.size(); i++) {
            if(i % 3 == 0) {
                destinationStart.add(Long.parseLong(AllNumbers.get(i)));
            } else if (i % 3 == 1) {
                sourceStart.add(Long.parseLong(AllNumbers.get(i)));
            } else {
                range.add(Long.parseLong(AllNumbers.get(i)));
            }
        }
    }

}
