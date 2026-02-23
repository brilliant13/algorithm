import java.util.*;
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        char[] charSwap = sc.next().toCharArray();
        
        int[] arrayBall = new int[4 + 1];
        arrayBall[1] = 1;
        arrayBall[4] = 9;

        
        for (char c : charSwap) {
            if ((c + "").equals("A")) {
                int temp = arrayBall[1];
                arrayBall[1] = arrayBall[2];
                arrayBall[2] = temp;
            }
            else if ((c + "").equals("B")) {
                int temp = arrayBall[1];
                arrayBall[1] = arrayBall[3];
                arrayBall[3] = temp;
            }
            else if ((c + "").equals("C")) {
                int temp = arrayBall[1];
                arrayBall[1] = arrayBall[4];
                arrayBall[4] = temp;
            }
            else if ((c + "").equals("D")) {
                int temp = arrayBall[2];
                arrayBall[2] = arrayBall[3];
                arrayBall[3] = temp;
            }
            else if ((c + "").equals("E")) {
                int temp = arrayBall[2];
                arrayBall[2] = arrayBall[4];
                arrayBall[4] = temp;
            }
            else if ((c + "").equals("F")) {
                int temp = arrayBall[3];
                arrayBall[3] = arrayBall[4];
                arrayBall[4] = temp;
            }
        }

        
        for (int i = 0; i < 5; i++) {
            if (arrayBall[i] == 1) {
                System.out.println(i);
            }
        }
        for (int i = 0; i < 5; i++) {
            if (arrayBall[i] == 9) {
                System.out.print(i);
            }
        }
 
    }
}