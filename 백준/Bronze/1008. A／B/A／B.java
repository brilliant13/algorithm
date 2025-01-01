import java.util.*;
public class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a,b;
        while(true){
            a = sc.nextInt();
            b = sc.nextInt();
            try{
                System.out.println((double)a/b);
                break;
            }
            catch (ArithmeticException e){
                System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요");
            }
        }
        sc.close();
       
    }
}