package Day_11;

import shared.DataSet;

import java.util.ArrayList;

public class GalaxyMap {

    ArrayList<Galaxy> galaxies;

    public GalaxyMap (DataSet filename) {
        spaceExpand(filename);
        setGalaxies(filename);
    }

    public boolean canExpandX (DataSet file, int i) {
        for(int j = 0; j < file.getLines().size(); j++) {
            if(file.getLines().get(j).charAt(i) == '#') {
                return false;
            }
        }
        return true;
    }

    public boolean canExpandY (String line) {
        for(Character c : line.toCharArray()) {
            if(c == '#') {
                return false;
            }
        }
        return true;
    }

    public void spaceExpand (DataSet file) {
        // expansion in y
        for(int i = 0; i < file.getLines().size(); i++) {
            if (canExpandY(file.getLines().get(i))) {
                String nextLine = ".".repeat(file.getLines().get(i).length());
                file.getLines().add(i, nextLine);
                i++;
            }
        }

        // expansion in x
        int size = file.getLines().getFirst().length();
        for(int i = 0; i < size; i++) {
            if (canExpandX(file, i)) {
                for(int j = 0; j < file.getLines().size(); j++) {
                    String line = file.getLines().get(j);
                    file.getLines().set(j, line.substring(0, i) + "." + line.substring(i));
                }
                size++;
                i++;
            }
        }

//        file.printLines();
//        System.out.println("Expanded size: y = " + file.getLines().size() + " x = " + file.getLines().getFirst().length());
    }

    public ArrayList<Galaxy> setGalaxies (DataSet filename) {
        galaxies = new ArrayList<>();
        for(int i = 0; i < filename.getLines().size(); i++) {
            for(int j = 0; j < filename.getLines().get(i).length(); j++) {
                char symbol = filename.getLines().get(i).charAt(j);
                if(symbol == '#') {
                    galaxies.add(new Galaxy(j,i));
                }
            }
        }
//        System.out.println(galaxies.size());
        return galaxies;
    }
}
