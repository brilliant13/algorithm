import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //괄호 균형 문제
        //왼쪽 ( or [ 만나면 스택에 저장
        //오른쪽괄호 ) or } 만나면 pop해서 매핑 잘 되어있는지 판단
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Stack<> 스택사용법 까 먹음.
        String str;
        StringBuilder sb = new StringBuilder();
        while (true) {
            str = br.readLine();
            if (str.equals(".")) {
                System.out.print(sb);
                break;
            }
            sb.append(ParenthesisChecker(str)? "yes":"no").append('\n');
        }

    }

    public static boolean ParenthesisChecker(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.equals(' ')) return true;
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) return false;
                if(stack.pop()!='(') return false;
            } else if (ch ==']') {
                if(stack.isEmpty()) return false;
                if(stack.pop()!='[') return false;
            }
        }
        return stack.isEmpty();
    }

}

