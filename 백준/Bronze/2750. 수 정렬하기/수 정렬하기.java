import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
        
		int N = Integer.parseInt(br.readLine());
        
		boolean[] arr = new boolean[2001];
		
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000] = true;
		}
 
		// 정렬 과정이 따로 필요 없음
		
		for(int i = 0; i < 2001; i++) {
			if(arr[i]) {
				sb.append(i - 1000).append('\n');
			}
		}
		System.out.println(sb);
	}
}