import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dial = br.readLine();
        int time =0;
        for (int i = 0; i < dial.length(); i++) {
            if(dial.charAt(i)=='A' || dial.charAt(i)=='B' ||dial.charAt(i)=='C') time+=3;
            else if(dial.charAt(i)=='D' || dial.charAt(i)=='E' ||dial.charAt(i)=='F') time+=4;
            else if(dial.charAt(i)=='G' || dial.charAt(i)=='H' ||dial.charAt(i)=='I') time+=5;
            else if(dial.charAt(i)=='J' || dial.charAt(i)=='K' ||dial.charAt(i)=='L') time+=6;
            else if(dial.charAt(i)=='M' || dial.charAt(i)=='N' ||dial.charAt(i)=='O') time+=7;
            else if(dial.charAt(i)=='P' || dial.charAt(i)=='Q' ||dial.charAt(i)=='R'||dial.charAt(i)=='S') time+=8;
            else if(dial.charAt(i)=='T' || dial.charAt(i)=='U' ||dial.charAt(i)=='V') time+=9;
            else if(dial.charAt(i)=='W' || dial.charAt(i)=='X' ||dial.charAt(i)=='Y'||dial.charAt(i)=='Z') time+=10;
        }
        System.out.println(time);
    }
}
