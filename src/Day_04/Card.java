import java.util.ArrayList;

public class Card {
    ArrayList<Integer> winningNumbers;
    ArrayList<Integer> cardNumbers;

    public Card () {
        this.winningNumbers = new ArrayList<>();
        this.cardNumbers = new ArrayList<>();
    }

    public void fillNumbers (String line) {
        String[] SplitGame = line.split(": ")[1].split("\\|");

        for (String str : SplitGame[0].split(" ")) {
            if (!str.isEmpty()) {
                this.winningNumbers.add(Integer.parseInt(str));
            }
        }

        for(String str : SplitGame[1].split(" ")) {
            if(!str.isEmpty()) {
                this.cardNumbers.add(Integer.parseInt(str));
            }
        }
    }

    public void printWinningNumbers () {
        for (Integer winningNumber : winningNumbers) {
            System.out.print(winningNumber + ", ");
        }
        System.out.println();
    }

    public void printCardNumbers () {
        for (Integer cardNumber : cardNumbers) {
            System.out.print(cardNumber + ", ");
        }
        System.out.println();
    }
}
