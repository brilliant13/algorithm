import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; static int R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        char[] sanggeun = st.nextToken().toCharArray();

        N = Integer.parseInt(br.readLine());
        char[][] friends = new char[N][R];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            friends[i] = st.nextToken().toCharArray();
        }

        int score = 0;
        for(int j = 0; j<R; j++){
            for(int i = 0; i<N; i++){
                score += getScore(sanggeun[j], friends[i][j]);
            }
        }

        int bestScore = 0;
        for(int j = 0; j<R; j++){
            int rScore = 0;
            int sScore = 0;
            int pScore = 0;
            for(int i = 0; i<N; i++){
                rScore += getScore('R', friends[i][j]);
                sScore += getScore('S', friends[i][j]);
                pScore += getScore('P', friends[i][j]);
            }
            bestScore+= Math.max(rScore, Math.max(sScore, pScore));
        }

        System.out.println(score);
        System.out.println(bestScore);
    }
    public static int getScore(char sanggeun, char friend){
        if(sanggeun == friend)
            return 1;
        switch (sanggeun){
            case 'R':
                return friend == 'S' ? 2 : 0;
            case 'S':
                return friend == 'P' ? 2 : 0;
            case 'P':
                return friend == 'R' ? 2 : 0;
            default: return 0;
        }
    }
}