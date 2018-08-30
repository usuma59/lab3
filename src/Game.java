import java.util.Scanner;

public class Game {
    private static OX ox ;
    private static Scanner sc = new Scanner(System.in);
    private static int col, row;

    public static void input() {
        System.out.println(ox.getCurrentPlayer() + " (Col) : ");
        col = sc.nextInt();
        System.out.println(ox.getCurrentPlayer() + " (Rol) : ");
        row = sc.nextInt();
    }

    public static void main (String[] arge) {

        ox = new OX();
        while (true) {
            System.out.println(ox.getTableString());
            input();
            ox.put(col, row);
            ox.switchPlayer();
            if(ox.checkWin(col,row)){
                break;
            }
        }

    }
}
