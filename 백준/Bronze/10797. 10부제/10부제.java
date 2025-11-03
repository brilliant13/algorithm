import java.util.*;

public class Main{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int car = sc.nextInt();
    int count =0;
    for(int i=0; i<5; i++){
        if(car == sc.nextInt()){
            count++;
        }
    }
    System.out.println(count);
    sc.close();
}
}