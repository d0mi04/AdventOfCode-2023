package Day_05;

import java.util.ArrayList;
import java.util.HashMap;

public class Garden {
    HashMap<Long, Long> SeedsMap;
    ArrayList<CorrespondingMap> allMaps;

    public Garden(DataSet file) {
        this.SeedsMap = CreateSeedsMap(GetSeeds(file.maps.getFirst()));
        this.allMaps = CreateAllMaps(file);
    }

    public int getDestinationIndex (Long value, int counter) {
        for(int i = 0; i < allMaps.get(counter).sourceStart.size(); i++) {
            Long start = allMaps.get(counter).sourceStart.get(i);
            Long end = start + allMaps.get(counter).range.get(i) - 1;
            if(value >= start && value <= end ) {
                return i;
            }
        }
        return -1;
    }

    public Long gardening () {
        for(int counter = 0; counter < allMaps.size(); counter++) {
            for(Long seed : SeedsMap.keySet()) {
                int index = getDestinationIndex(SeedsMap.get(seed), counter);
                if(index != -1) {
                    Long diff = SeedsMap.get(seed) - allMaps.get(counter).sourceStart.get(index);
                    Long result = diff + allMaps.get(counter).destinationStart.get(index);
                    SeedsMap.put(seed, result);
                }
            }
        }

        Long minValue = Long.MAX_VALUE;
        for(Long value : SeedsMap.values()) {
            if(value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }

    public ArrayList<CorrespondingMap> CreateAllMaps(DataSet file) {
        ArrayList<CorrespondingMap> map = new ArrayList<>();

        for(int i = 1; i < file.maps.size(); i++) {
            CorrespondingMap cm = new CorrespondingMap(file.maps.get(i));
            map.add(cm);
        }

        return map;
    }

    public HashMap<Long, Long> CreateSeedsMap (ArrayList<Long> seeds) {
        HashMap<Long, Long> seedHashMap = new HashMap<>();
        for(Long seed : seeds) {
            seedHashMap.put(seed, seed);
        }

        return seedHashMap;
    }

    public ArrayList<Long> GetSeeds(String line) {
        ArrayList<Long> seedsArray = new ArrayList<>();
        String[] Split = line.split(": ");
        String[] numbers = Split[1].split("\\s+");

        for(String number : numbers) {
            Long seed = Long.parseLong(number);
            seedsArray.add(seed);
        }
        return seedsArray;
    }
}
