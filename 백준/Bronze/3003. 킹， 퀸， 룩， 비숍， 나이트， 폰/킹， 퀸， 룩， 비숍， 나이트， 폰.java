import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //낡은 체스판과 피스 발견
        //검정색 피스는 모두 있다. 흰색 피스는 개수가 틀림
        //16개의 피스
        //킹, 퀸,룩,비숍,나이트,폰의 개수가 주어짐.
        //1 1 2 2 2 8

        Scanner in = new Scanner(System.in);

        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int knight = 2;
        int pawn = 8;

        king = king - in.nextInt();
        queen = queen - in.nextInt();
        rook = rook - in.nextInt();
        bishop = bishop - in.nextInt();
        knight = knight - in.nextInt();
        pawn = pawn - in.nextInt();

        System.out.print(king + " ");
        System.out.print(queen + " ");
        System.out.print(rook + " ");
        System.out.print(bishop + " ");
        System.out.print(knight + " ");
        System.out.print(pawn);
    }


}
