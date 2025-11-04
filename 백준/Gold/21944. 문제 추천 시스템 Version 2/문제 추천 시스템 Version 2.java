import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Problem {
        int p, l, g;

        Problem(int p, int l, int g) {
            this.p = p;
            this.l = l;
            this.g = g;
        }
    }

    public static void main(String[] args) throws IOException {
        // [21944] 문제 추천 시스템 Version 2
        //"문제번호P, 난이도L, 알고리즘 분류G"
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //난이도 L 오름차순, 문제번호 P 오름차순
        Comparator<Problem> order = Comparator
                .comparingInt((Problem q) -> q.l)
                .thenComparingInt(q -> q.p);

        //필요한 자료구조
        TreeSet<Problem> all = new TreeSet<>(order);
        Map<Integer, TreeSet<Problem>> byGroup = new HashMap<>();
        Map<Integer, Problem> byP = new HashMap<>();

        //문제정보 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            Problem cur = new Problem(p, l, g);

            //전체 조회용
            all.add(cur);
            //그룹용
            //없으면 TreeSet만들어서 뱉고, 있으면 가져와서 뱉고
            byGroup.computeIfAbsent(g, k -> new TreeSet<>(order)).add(cur);
            //solved용
            byP.put(p, cur);
        }

        int M = Integer.parseInt(br.readLine());
        //명령 입력
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String[] strs = br.readLine().split(" ");
            if (strs[0].equals("add")) {
                int p = Integer.parseInt(strs[1]);
                int l = Integer.parseInt(strs[2]);
                int g = Integer.parseInt(strs[3]);
                Problem newP = new Problem(p, l, g);
                all.add(newP);
                byGroup.computeIfAbsent(g, k -> new TreeSet<>(order)).add(newP);
                byP.put(p, newP);
            } else if (strs[0].equals("recommend")) { //알고리즘 분류 G중 가장 어려운 문제 or 가장 쉬운 문제 // Map<Integer, TreeSet<Problem>> byGroup = new HashMap<>();
                int g = Integer.parseInt(strs[1]);
                int x = Integer.parseInt(strs[2]);
                if (x == 1) {
                    sb.append(byGroup.get(g).last().p).append('\n');
                } else {
                    sb.append(byGroup.get(g).first().p).append('\n');
                }
            } else if (strs[0].equals("recommend2")) { //전체 중 가장 어려운 문제 or 가장 쉬운 문제 //TreeSet<Problem> all = new TreeSet<>(order);
                int x = Integer.parseInt(strs[1]);
                if (x == 1) {
                    sb.append(all.last().p).append('\n');
                } else {
                    sb.append(all.first().p).append('\n');
                }
            } else if (strs[0].equals("recommend3")) { //난이도 L보다 크거나 같은 것 중 가장 쉬운 문제 번호 (tie : p 작은 것 출력)  또는 난이도 L보다 작은 것 중 가장 어려운 문제번호(tie: p 큰것 출력)
                int x = Integer.parseInt(strs[1]);
                int l = Integer.parseInt(strs[2]);
                if (x == 1) {
                    Problem problem = new Problem(Integer.MIN_VALUE,l,0); //g는 값 상관없지?
                    Problem ans = all.ceiling(problem);
                    //난이도 이상인게 없을 수도 있으니까.
                    sb.append(ans == null ? -1 : ans.p).append('\n');
                }else {
                    Problem problem = new Problem(Integer.MIN_VALUE,l,0); //g는 값 상관없지?
                    Problem ans = all.lower(problem);
                    sb.append(ans==null ? -1 : ans.p).append('\n');
                }
            } else { //solved
                int p = Integer.parseInt(strs[1]);
                //            byP.put(p, cur);
                //byP.remove하면 제거하면서 뱉을 수 있음
//                Problem problem = byP.get(p);
                Problem problem = byP.remove(p);
                all.remove(problem);
                byGroup.get(problem.g).remove(problem);
                //byGroup.computeIfAbsent(g, k -> new TreeSet<>(order)).add(cur);
            }
        }

        System.out.print(sb);


    }
}