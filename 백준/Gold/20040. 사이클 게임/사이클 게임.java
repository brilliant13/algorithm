import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //Union Find, DSU 분리집합은 어떤 그룹인지 바로 찾게해주는, 또 입력값이 같은 그룹인지 아닌지를 판단해서 바로바로 그룹지어주는 자료구조이다.
    //여러 개의 그룹(집합)을 관리하면서, 그룹끼리 합치기 + 같은 그룹인지 확인하기"를 빠르게 하는 자료구조이다.

    static int[] parent;

    //root찾기. 같은 그룹인지 찾기. DSU(Disjoint Set Union, 분리집합 합집합연산), Union(합병), Find(찾기)
    static int find(int x) {
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]); //경로 압축(Path Compression, 한번 계산해두면 나중에 find(x)조회할 때 다시 역추적 할 필요없이 O(1)로 바로 어떤 그룹인지 루트노드 번호 반환해줌)
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b) return false; //이미 같은 집합 -> 이 간선을 넣으면 cycle이 형성되는 것이다.
        parent[b] = a; //아무쪽이나 부모로
        return true;
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; //초기엔 각자 자기 자신이 대표
        }

        int answer = 0;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //union이 실패했다 = 이미 같은 집합이다 = 이 간선이 cycle을 만든다.
            if(!union(a,b)){
                if(answer==0) answer = i; //처음으로 cycle 생긴 턴
            }
        }
        System.out.print(answer);
    }
}

