package Flood;

import java.util.Scanner;

public class Main {

    static Flood flood = new Flood();
    static Control control = new Control();
    static final int MAX_TURNS = 21;

    public static void main(String[] args) throws CloneNotSupportedException {
        control.BFS(new Node(null,flood,0));
        startGame();
    }

    public static void startGame(){
        Scanner scanner = new Scanner(System.in);
        int turns = 0;
        boolean exit = false;
        while (!exit){
            System.out.println("Move : " + (turns+0));
            if (turns == MAX_TURNS){
                System.out.println("You lost!");
                break;
            }
            if (flood.solved()){
                System.out.println("Congratulations, Puzzle is successfully solved!");
                break;
            }else {
                flood.printTable();
                System.out.println("Choose the next color!");
                String color = scanner.nextLine().toLowerCase();
                switch (color) {
                    case "y":
                        flood.startFilling(Flood.colors.Y);
                        break;
                    case "o":
                        flood.startFilling(Flood.colors.O);
                        break;
                    case "r":
                        flood.startFilling(Flood.colors.R);
                        break;
                    case "g":
                        flood.startFilling(Flood.colors.G);
                        break;
                    case "b":
                        flood.startFilling(Flood.colors.B);
                        break;
                    case "p":
                        flood.startFilling(Flood.colors.P);
                        break;
                    case "exit":
                        exit = true;
                        break;
                    default:
                        System.out.println("Unexpected value: " + color);
                        break;
                }
                turns++;
            }
        }
    }
}
