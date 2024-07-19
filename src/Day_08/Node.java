package Day_08;

public class Node {
    String value;
    String left;
    String right;

    public Node(String line) {
        setNode(line);
    }

    public void setNode(String line) {
        String[] split = line.split(" = ");
        value = split[0];

        String[] nextSplit = split[1].split(", ");
        left = nextSplit[0].replace("(", "");
        right = nextSplit[1].replace(")", "");

//        System.out.println("node: " + value + " left: " + left + " right: " + right);
    }
}
