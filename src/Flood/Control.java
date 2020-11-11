package Flood;

import java.util.LinkedList;
import java.util.List;

public class Control {
    private List<Node> listOfNodes = new LinkedList<Node>();

    public boolean addNode(Node node){
        return listOfNodes.add(node);
    }

//    public boolean removeHead(){
//        if (listOfNodes.size() == 0)
//            return false;
//        listOfNodes.remove(0);
//        return true;
//    }

    public void addNeighbors(Node node) throws CloneNotSupportedException {
        Flood.colors currentColor = node.getFlood().getBoard()[0][0];
        for (int i = 0; i < Flood.colors.values().length; i++){
            if (Flood.colors.values()[i] != currentColor){
                Node coloredNode = new Node(node,node.getFlood().clone(),(node.getSteps())+1);
                coloredNode.getFlood().startFilling(Flood.colors.values()[i]);
                listOfNodes.add(coloredNode);
            }
        }
        System.out.println("Current depth is " + node.getSteps());
        listOfNodes.remove(0);
    }

    public void BFS(Node node) throws CloneNotSupportedException {
        addNode(node);
        LinkedList<Node> solution = new LinkedList<>();
        while (true){
            if (listOfNodes.get(0).getFlood().solved()){
                Node currentNode = listOfNodes.get(0);
                while (true) {
                    solution.add(0, currentNode);
                    if (currentNode.getParent() == null)
                        break;
                    currentNode = currentNode.getParent();
                }
                break;
            }
            if ((listOfNodes.size() % 20000) < 5){
                System.out.println("Current size is " + listOfNodes.size());
            }
            addNeighbors(listOfNodes.get(0));
        }
        System.out.println("You can solve this puzzle in " + (solution.size()-1) + " moves");
    }
}
