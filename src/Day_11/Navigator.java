package Day_11;

import shared.DataSet;

public class Navigator {
    GalaxyMap galaxyMap;

    public Navigator (DataSet filename) {
        this.galaxyMap = new GalaxyMap(filename);
    }

    public void countDistance (GalaxyMap galaxyMap) {
        int sum = 0;
        for (int i = 0; i < galaxyMap.galaxies.size(); i++) {
            for(int j = i + 1; j < galaxyMap.galaxies.size(); j++) {
                sum += findPath(galaxyMap.galaxies.get(i), galaxyMap.galaxies.get(j));
            }
        }
        System.out.println(sum);
    }

    public int findPath (Galaxy galaxy1, Galaxy galaxy2) {
        int distance = 0;
        int distX = Math.abs(galaxy1.x - galaxy2.x);
        int distY = Math.abs(galaxy1.y - galaxy2.y);
        distance = distX + distY;
//        System.out.println(distance);
        return distance;
    }
}
