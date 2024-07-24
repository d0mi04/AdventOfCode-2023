package Day_09;

public class Node {
    int previous;
    int next;
    int difference;

    public Node(int previous, int next, int difference) {
        this.previous = previous;
        this.next = next;
        this.difference = difference;
    }

    public void print () {
        System.out.println("previous: " + previous + " next: " + next + " difference: " + difference);
    }

}
