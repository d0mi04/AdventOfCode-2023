package Day_02;

public class December02 {
    public static void main() {
        OpeningFiles file = new OpeningFiles("src/Day_02/input-02.txt");
        int sumId = 0;
        int sumPowers = 0;

        for(String line : file.lines) {
            GameLogic game = new GameLogic(line);
            sumPowers += game.MakeGamePossible();
            if(game.isGameValid()) {
                sumId += game.game.id;
            }

        }
        System.out.printf("Sum of valid games: %d\n", sumId);
        System.out.printf("Sum of powers: %d\n", sumPowers);
    }
}
