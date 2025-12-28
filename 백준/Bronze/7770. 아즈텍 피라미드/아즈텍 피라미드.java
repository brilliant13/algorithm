import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int A = 1;
		int B = 1;
		int i = 1;
        
		while(true) {
			B += 4 * i;
			A += B;
			if(A > n) {
				break;
			}
			i++;
		}
		System.out.println(i);
	}

}