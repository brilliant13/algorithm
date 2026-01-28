import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int precedence(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0; // '(' 등
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ('A' <= ch && ch <= 'Z') {
                out.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    out.append(stack.pop());
                }
                stack.pop(); //'(' 제거
            } else { //연산자 + - * /
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    if(stack.peek() == '(')break;
                    out.append(stack.pop());
                }
                //현재 차례의 op보다 우선순위 높거나 같은 연산자들 다 뽑았으면 이제 넣어준다.
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            out.append(stack.pop());
        }

        System.out.print(out.toString());

    }
}


