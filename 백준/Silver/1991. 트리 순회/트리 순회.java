import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char data; Node left, right;
        Node(char d) { data = d; }
    }

    static Map<Character, Node> nodes = new HashMap<>();
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in  = new StringBuilder();
    static StringBuilder post= new StringBuilder();

    static Node get(char c) {  // 필요할 때만 생성
        //HashMap사용
        return nodes.computeIfAbsent(c, k -> new Node(k));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            Node parent = get(p);
            parent.left  = (l == '.') ? null : get(l);
            parent.right = (r == '.') ? null : get(r);
        }

        Node root = nodes.get('A'); // 문제 조건: 항상 A가 루트
        preorder(root);  System.out.println(pre);
        inorder(root);   System.out.println(in);
        postorder(root); System.out.println(post);
    }

    static void preorder(Node n) {
        if (n == null) return;
        pre.append(n.data);
        preorder(n.left);
        preorder(n.right);
    }
    static void inorder(Node n) {
        if (n == null) return;
        inorder(n.left);
        in.append(n.data);
        inorder(n.right);
    }
    static void postorder(Node n) {
        if (n == null) return;
        postorder(n.left);
        postorder(n.right);
        post.append(n.data);
    }
}
