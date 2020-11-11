package Flood;

import java.util.Random;

public class Flood implements Cloneable{

    private colors[][] board;
    private final int N = 3;

    public enum colors{
        Y,O,R,G,B,P;
    }

    public Flood() {
        this.board = new colors[N][N];
        fillTheGrid();
    }

    public Flood(colors[][] board) {
        this.board = board;
    }

    public colors[][] getBoard() {
        return board;
    }

    public void fillTheGrid(){
        Random rand = new Random();
        for (int i = 0; i < N ; i++){
            for (int j = 0; j < N; j++){
                this.board[i][j] = colors.values()[rand.nextInt(colors.values().length)];
            }
        }
    }

    public void startFilling(colors nextColor){
        if (this.board[0][0] == nextColor){
            return;
        }
        coloring(0,0,this.board[0][0],nextColor);
    }

    public void coloring(int y, int x, colors initCol, colors nextColor){
        this.board[y][x] = nextColor;
        if (eligible(y,x+1,initCol)){
            coloring(y,x+1,initCol,nextColor);
        }
        if (eligible(y,x-1,initCol)){
            coloring(y,x-1,initCol,nextColor);
        }
        if (eligible(y+1,x,initCol)){
            coloring(y+1,x,initCol,nextColor);
        }
        if (eligible(y-1,x,initCol)){
            coloring(y-1,x,initCol,nextColor);
        }
    }

    public boolean eligible(int y,int x, colors initColor){
        if (y >= 0 && y < N && x >= 0 && x < N)
            if (this.board[y][x] == initColor)
                return true;
        return false;
    }

    public boolean solved(){
        colors color = this.board[0][0];
        for (int i = 0; i < N ; i++){
            for (int j = 0; j < N; j++){
                if (color != this.board[i][j])
                    return false;
            }
        }
        return true;
    }

    public void printTable(){
        for (int i = 0; i < N ; i++){
            for (int j = 0; j < N; j++){
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    protected Flood clone() throws CloneNotSupportedException {
        Flood newFlood = new Flood();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                newFlood.board[i][j] = this.board[i][j];
            }
        }
        return newFlood;
    }
}
