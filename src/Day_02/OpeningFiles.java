package Day_02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OpeningFiles {
    ArrayList<String> lines;

    public OpeningFiles(String filename) {
        this.lines = ReadingFile(filename);
    }

    public ArrayList<String> ReadingFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();

            while(line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
