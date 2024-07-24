package Day_02;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    int id;
    ArrayList<HashMap<String, Integer>> colors;

    public Game (String line) {
        this.id = CreateID(line);
        this.colors = CreateColors(line);
//        printGameDetails();
    }

    public void printGameDetails() {
        System.out.println("Game id: " + id);
        for(HashMap<String, Integer> c : colors) {
            System.out.println(c);
        }
    }

    public int CreateID (String line) {
        String[] SplitGame = line.split(": ");
        int id = Integer.parseInt(SplitGame[0].split(" ")[1]);
        return id;
    }

    public ArrayList<HashMap<String, Integer>> CreateColors (String line) {
        String[] SplitGame = line.split(": ");
        String[] gameArray = SplitGame[1].split("; ");

        ArrayList<HashMap<String, Integer>> oneGame = new ArrayList<>();


        for(int i = 0; i < gameArray.length; i++) { // ta pętla dzieli na rundy
            String[] round = gameArray[i].split(", ");
//            int value = Integer.parseInt(gameArray[i].split(", ")[0]);
            for(int j = 0; j < round.length; j++) { // a tu mamy podział każdej rundy na kolory - to musimy zapisać do HashMapy
                String[] roundSplit = round[j].split(" ");

                for (int k = 0; k < roundSplit.length; k+=2) {
//                    System.out.print(roundSplit[k] + " ");
                    HashMap<String, Integer> colors = new HashMap<>();
                    colors.put(roundSplit[k+1], Integer.parseInt(roundSplit[k]));
                    oneGame.add(colors);
//                    System.out.println(colors);
                }
            }
//            System.out.println("next round");
        }

        return oneGame;
    }
}
