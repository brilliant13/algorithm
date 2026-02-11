import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String driip = br.readLine();

    System.out.println(driip.endsWith("driip") ? "cute" : "not cute");
    }
}