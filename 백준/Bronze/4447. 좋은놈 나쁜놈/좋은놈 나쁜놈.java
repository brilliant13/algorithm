import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testCase = Integer.parseInt(br.readLine());
        List<String> inputList = new ArrayList<>();
        for (int i = 0; i < testCase; i++) {
            inputList.add(br.readLine());
        }
        System.out.print(solution(inputList));
    }

    public static String solution(List<String> inputList) {
        StringBuilder sb = new StringBuilder();
        inputList.forEach(input -> {
            sb.append(input).append(" is ");

            final String lowerCaseInput = input.toLowerCase(Locale.ROOT);
            final int gCount = lowerCaseInput.split("g", -1).length - 1;
            final int bCount = lowerCaseInput.split("b", -1).length - 1;

            if (gCount > bCount) {
                sb.append("GOOD");
            } else if (gCount < bCount) {
                sb.append("A BADDY");
            } else {
                sb.append("NEUTRAL");
            }

            sb.append("\n");
        });

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}