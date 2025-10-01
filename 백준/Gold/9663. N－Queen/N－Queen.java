import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, count;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = 0;
        dfs(0);
        System.out.print(count);
    }

    static void dfs(int depth) {
        if (depth == N) { //N까지 왔다면 바로 출력해야 하나?
            //depth에서 모든 열이 다 퀸의 루트로 걸려있다면(1 이상), 다음dfs호출 못한다. 다음 깊이로 못내려간다. dfs의 깊이가 못 깊어진다.
            count++;
            return;
        }

        if (depth == 0) { //깊이 0일 때만 방문, 맵 초기화
            map = new int[N][N];
        }

        for (int i = 0; i < N; i++) { //해당 깊이 행에서 0~N-1중 하나 선택
            //map당 count로 방문처리 비교할 수 있으니까, 방문처리배열 따로 안 필요함.
            //[depth=1][0] 가정
            //선택
            if(map[depth][i]>0)continue; //퀸이 방문하는 자리면 다음 차례로 넘어가서 검사
            //매 depth마다 퀸을 놓았는지 검사할 필요가 있나? N깊이까지 도달했다는 건 dfs가 계속 깊어진거고
            //dfs가 깊어졌다는건 매 depth마다 퀸을 놓고, continue를 안했기 때문이라는 방증이다.
            map[depth][i]++;
            ////////////////////////////////////////////////////////////////////////////////
            //대각, 세로 방문처리
            //세로
            for (int k = depth + 1; k < N; k++) {
                map[k][i]++;
            }
            //대각 아래
            //(depth,i)
            //대각 y감소
            for (int p = 1; p < N - depth; p++) {
                int nx = depth + p;
                int ny = i - p;
                if (nx < N && ny >= 0) map[nx][ny]++;
            }
            //대각 y증가
            for (int p = 1; p < N - depth; p++) {
                int nx = depth + p;
                int ny = i + p;
                if (nx < N && ny < N) map[nx][ny]++;
            }
            ////////////////////

            //재귀호출
            //백트랙킹 하기전에 재귀호출하니까, 현재까지의 상황이 dfs(depth+1)다음 호출로 전달됨.
            dfs(depth + 1);


            //backtracking
            //다음 for문 들어가기 전에 방문처리 취소해서, 해당 depth에서의 다른 선택사항 검사. [depth=1][4]
            map[depth][i]--;
            //세로
            for (int k = depth + 1; k < N; k++) {
                map[k][i]--;
            }
            //대각 y감소
            for (int p = 1; p < N - depth; p++) {
                int nx = depth + p;
                int ny = i - p;
                if (nx < N && ny >= 0) map[nx][ny]--;
            }
            //대각 y증가
            for (int p = 1; p < N - depth; p++) {
                int nx = depth + p;
                int ny = i + p;
                if (nx < N && ny < N) map[nx][ny]--;
            }
            ////////////////////////////////////////////////////////////////////////////////
        }
    }
}
