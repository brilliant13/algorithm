import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int total = 0;
		
		for(int i = 0; i < t; i++) {
			int g = sc.nextInt();
			int c = sc.nextInt();
			int e = sc.nextInt();
			
			if(g == 1) {
				total = e - c;
			}else if(g == 2) {
				total = (e - c) * 3;
			}else if(g == 3) {
				total = (e - c) * 5;
			}
			
			if(c >= e) {
				total = 0;
			}
			System.out.println(total);
		}
		sc.close();
	}
}