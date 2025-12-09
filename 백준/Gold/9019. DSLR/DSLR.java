import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            //HashMap + BFS로 경로 구ㅐ서 바로 출력
            sb.append(bfs(A, B)).append('\n');
        }
        System.out.print(sb);
    }

    //HashMap을 이용한 BFS
    static String bfs(int A, int B) {
        Queue<Integer> q = new ArrayDeque<>();
        HashMap<Integer, String> map = new HashMap<>(); //상태 -> 연산 문자열

        q.add(A);
        map.put(A, ""); //시작 상태까지의 연산은 없음

        while (!q.isEmpty()) {
            int cur = q.poll();
            String curPath = map.get(cur);

            //목표 숫자에 도달하면 그 순간의 문자열이 최단 경로
            if (cur==B) return curPath;

            //4가지 연산
            int d = D(cur);
            int s = S(cur);
            int l = L(cur);
            int r = R(cur);

            //D
            if (!map.containsKey(d)) {
                map.put(d, curPath + "D");
                q.add(d);
            }
            //S
            if (!map.containsKey(s)) {
                map.put(s, curPath + "S");
                q.add(s);
            }
            //L
            if (!map.containsKey(l)) {
                map.put(l, curPath + "L");
                q.add(l);
            }
            //R
            if (!map.containsKey(r)) {
                map.put(r, curPath + "R");
                q.add(r);
            }
        }
        return ""; //문제 조건상 여기 도달하지 않음. 형식맞추기용.
    }


    static int D(int a) {
        return (2 * a) % 10000;
    }

    static int S(int a) {
        return a == 0 ? 9999 : a - 1;
    }

    static int L(int a) {
        //d1 d2 d3 d4 -> d2 d3 d4 d1
        //'0' + int -> (char)캐스팅
        // 문자열/char 안 쓰고 바로 숫자 연산으로 가능
//        char d1 = (char) ('0' + (a / 1000));
//        char d2 = (char) ('0' + (a % 1000) / 100);
//        char d3 = (char) ('0' + (a % 100) / 10);
//        char d4 = (char) ('0' + (a % 10));
        return (a % 1000) * 10 + +a / 1000;

        //char -> String
//        String sequence = "" + d1 + d2 + d3 + d4;
//        return Integer.parseInt(sequence);
    }

    static int R(int a) {
        //d1 d2 d3 d4 -> d4 d1 d2 d3
        //'0' + int -> (char)캐스팅
//        char d1 = (char) ('0' + a / 1000);
//        char d2 = (char) ('0' + (a % 1000) / 100);
//        char d3 = (char) ('0' + (a % 100) / 10);
//        char d4 = (char) ('0' + (a % 10));
        return (a % 10) * 1000 + (a / 10);


        //char -> String
//        String sequence = "" + d4 + d1 + d2 + d3;
//        return Integer.parseInt(sequence);
    }

}
