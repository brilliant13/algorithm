import java.io.*;
import java.util.StringTokenizer;

public class Main {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

int N = Integer.parseInt(br.readLine());
int a, b;
StringTokenizer st;
for (int i = 0; i < N; i++) {
st = new StringTokenizer(br.readLine(), " ");
a = Integer.parseInt(st.nextToken());
b = Integer.parseInt(st.nextToken());
bw.write(String.valueOf(a + b));
bw.newLine();
}
br.close();
bw.flush();
bw.close();
}
}