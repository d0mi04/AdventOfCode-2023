package Day_02;

import java.util.HashMap;

public class GameLogic {
    private static final int RED = 12;
    private static final int GREEN = 13;
    private static final int BLUE = 14;

    Game game;

    public GameLogic(String line) {
        this.game = new Game(line);
    }

    public int MakeGamePossible() {
        int red = 0;
        int green = 0;
        int blue = 0;

        for(HashMap<String, Integer> map : game.colors) {
            if(map.containsKey("red") && map.get("red") > red){
                red = map.get("red");
            }
            if(map.containsKey("green") && map.get("green") > green) {
                green = map.get("green");
            }
            if(map.containsKey("blue") && map.get("blue") > blue) {
                blue = map.get("blue");
            }
        }

        return red*green*blue;
    }

    public boolean isGameValid() {
        for(HashMap<String, Integer> map : game.colors) {
            if(map.containsKey("red") && map.get("red") > RED ||
                map.containsKey("green") && map.get("green") > GREEN ||
                map.containsKey("blue") && map.get("blue") > BLUE) {
                return false;
            }
        }
        return true;
    }

}
