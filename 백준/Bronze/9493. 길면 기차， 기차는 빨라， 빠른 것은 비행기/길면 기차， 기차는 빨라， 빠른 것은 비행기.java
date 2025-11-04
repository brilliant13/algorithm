import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//무한루프
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double M = Double.parseDouble(st.nextToken());
			double A = Double.parseDouble(st.nextToken());
			double B = Double.parseDouble(st.nextToken());
			
			//0 0 0 입력시 무한루프 종료
			if(M == 0 && A == 0 & B == 0) break;
			
			double result = Double.parseDouble(String.format("%.0f", (((M / A) - (M / B)) * 3600)));
			
			int h = (int) (result / 3600);
			int m = (int) ((result / 60) % 60);
			int s = (int) (result % 60);
			
			//기존 print가 아닌 format 사용.
			System.out.format("%d:%02d:%02d\n", h, m, s);
		}
	}

}