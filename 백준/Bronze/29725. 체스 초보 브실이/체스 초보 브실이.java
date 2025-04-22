import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int answer=0;
        for(int i=0; i<8; i++){
            String a=br.readLine();
            for(int j=0; j<8; j++){
                char temp=a.charAt(j);
                switch(temp){
                    case '.': break;
                    case 'K': answer+=0; break;
                    case 'P': answer+=1; break;
                    case 'N': answer+=3; break;
                    case 'B': answer+=3; break;
                    case 'R': answer+=5; break;
                    case 'Q': answer+=9; break;

                    case 'k': answer+=0; break;
                    case 'p': answer+=-1; break;
                    case 'n': answer+=-3; break;
                    case 'b': answer+=-3; break;
                    case 'r': answer+=-5; break;
                    case 'q': answer+=-9; break;

                }
            }
        }
        bw.write(answer+"");
        bw.flush();
    }
}
