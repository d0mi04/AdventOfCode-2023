package Day_08;

import shared.DataSet;

import java.util.ArrayList;
import java.util.Objects;

public class Map {
    // part 1:
    ArrayList<Node> mapOfNodes;
    ArrayList<Character> steps;

    public Map (DataSet file) {
        setMapOfNodes(file);
        setSteps(file);
    }

    public Node findNode(String value) {
        for(Node node : mapOfNodes) {
            if(Objects.equals(node.value, value)) {
                return node;
            }
        }
        return null;
    }

    // part 1:
    public int move () {
        Node currentStep = findNode("AAA"); // first step
        boolean exit = false;

        int howManySteps = 0;
        while (!exit) {
            for(Character step : steps) {
                if(Objects.equals(currentStep.value, "ZZZ")) {
                    exit = true;
                    break;
                } else if (step == 'L') {
                    howManySteps++;
                    currentStep = findNode(currentStep.left);
                } else if (step == 'R') {
                    howManySteps++;
                    currentStep = findNode(currentStep.right);
                }
            }
        }
        return howManySteps;
    }

    public void setSteps(DataSet file) {
        steps = new ArrayList<>();
        for(Character step : file.getLines().getFirst().toCharArray()) {
            steps.add(step);
//            System.out.println(step);
        }


    }

    public void setMapOfNodes(DataSet file) {
        mapOfNodes = new ArrayList<>();
        for(int i = 2; i < file.getLines().size(); i++) {
            mapOfNodes.add(new Node(file.getLines().get(i)));
        }
    }

}
