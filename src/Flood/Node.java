package Flood;

public class Node {
    private Node parent;
    private Flood flood;
    private int steps;

    public Node(Node parent, Flood flood, int steps) {
        this.parent = parent;
        this.flood = flood;
        this.steps = steps;
    }

    public Node getParent() {
        return parent;
    }

    public Flood getFlood() {
        return flood;
    }

    public int getSteps() {
        return steps;
    }

}
