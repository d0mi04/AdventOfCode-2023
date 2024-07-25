public class December04 {

    public static void main (String[] args) {
        DataSet file = new DataSet("src/input-04.txt");

        Part1(file);
        Patr2(file);
    }

    public static void Patr2(DataSet file) {
        GameLogic game = new GameLogic();

        for(String line : file.lines) {
            game.findWinningNumbers(line);
        }

        game.CountWins();
    }

    public static void Part1(DataSet file) {
        GameLogic game = new GameLogic();

        for(String line : file.lines) {
            game.findWinningNumbers(line);
        }

        game.CountWorth();
        System.out.printf("Total worth of cards: %f\n", game.sumOfPoints);
    }
}
