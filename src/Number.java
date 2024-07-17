public class Number {
    String firstDigit;
    String lastDigit;
    int number;

    public Number (String line) {
        this.firstDigit = findFirstDigit(line);
        this.lastDigit = findLastDigit(line);
        this.number = createNumber(firstDigit, lastDigit);
    }

    public String findFirstDigit(String line) {
        String digit = "";
        for(char c : line.toCharArray()) {
            if(Character.isDigit(c)) {
                digit = String.valueOf(c);
                break;
            }
        }
        return digit;
    }

    public String findLastDigit(String line) {
        String digit = "";
        for(int i = line.length() - 1; i >= 0; i--) {
            if(Character.isDigit(line.charAt(i))) {
                digit = String.valueOf(line.charAt(i));
                break;
            }
        }
        return digit;
    }

    public int createNumber(String firstDigit, String lastDigit) {
        return Integer.parseInt(firstDigit+lastDigit);
    }
}
