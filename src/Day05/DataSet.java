package Day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class DataSet {
    ArrayList<String> maps;

    public DataSet (String filename) {
        this.maps = ReadFile(filename);
    }

    public ArrayList<String> ReadFile (String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            String input = new String(Files.readAllBytes(Paths.get(filename)));
            String[] getMaps = input.split("\\r?\\n\\r?\\n");

            lines.addAll(Arrays.asList(getMaps));


        } catch (IOException e ) {
            e.printStackTrace();
        }

        return lines;
    }
}
