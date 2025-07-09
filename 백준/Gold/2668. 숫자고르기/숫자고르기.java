import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, new ArrayList<>());
            }
        }

//        Collections.sort(result);
        result.sort(null);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }
    static void dfs(int current, List<Integer> path) {

        if(finished[current]) return;

        if (visited[current]) {
            int cycleStart = path.indexOf(current);
            for (int i = cycleStart; i < path.size(); i++) {
                result.add(path.get(i));//순환구조까지만
            }
            return;
        }

        visited[current] = true;
        path.add(current);

        dfs(arr[current], path);

        path.remove(path.size() - 1);

        finished[current] = true;
    }
}
