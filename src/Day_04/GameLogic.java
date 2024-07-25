import java.util.ArrayList;
import java.util.HashMap;

public class GameLogic {
    ArrayList<Integer> NumberCount;
    double sumOfPoints;

    public GameLogic() {
        this.NumberCount = new ArrayList<>();
        this.sumOfPoints = 0;
    }

    public void CountWins () {
        HashMap<Integer, Integer> cardsAndCounts = new HashMap<>();
        for(int i = 1; i <= NumberCount.size(); i++) {
            cardsAndCounts.put(i, 1);
        }

        for(int n = 0; n < NumberCount.size() - 1; n++) {
            for(Integer key : cardsAndCounts.keySet()) {
                int howManyWins = NumberCount.get(n);
//                System.out.println(howManyWins);
//                System.out.println("value: " + cardsAndCounts.get(n+1));
                int value = cardsAndCounts.get(n+1);
                for(int i = 1; i <= howManyWins; i++) { // if 1st card won 8 cards, we receive 8 following cards
                    for(int j = 0; j < value; j++) { // how many card there are, that many times we "use" them, considering already won cards
                        cardsAndCounts.put(n+i+1, cardsAndCounts.get(n+i+1) + 1);
//                      System.out.println(cardsAndCounts);
                    }
                }
                break;
            }
        }

        int sum = 0;
        for(Integer value : cardsAndCounts.values()) {
            sum += value;
        }
        System.out.printf("Sum of all won cards: %d\n", sum);
    }

    public void CountWorth () {
        for (Integer integer : NumberCount) {
            double worth;
            if (integer != 0) {
                worth = Math.pow(2, integer - 1);
                sumOfPoints += worth;
            }
        }
    }

    public void findWinningNumbers(String line) {
        Card card = new Card();
        card.fillNumbers(line);

        int count = 0;
        for(Integer number : card.winningNumbers) {
            if(card.cardNumbers.contains(number)) {
                count++;
            }
        }
        NumberCount.add(count);
    }

    public void printNumberCount () {
        for (Integer integer : NumberCount) {
            System.out.print(integer + ", ");
        }
        System.out.println();
    }
}
