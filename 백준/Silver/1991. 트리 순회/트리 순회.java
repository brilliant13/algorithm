import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Node root;

    public static void init(char data, char leftData, char rightData) {
        if (root == null) {
            root = new Node(data);
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public static void searchNode(Node node, char data, char leftData, char rightData) {
        if (node == null) return;
        if (node.data == data) {
            if (leftData != '.') {
                node.left = new Node(leftData);
            }
            if (rightData != '.') {
                node.right = new Node(rightData);
            }
        } else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    public static void preOrder(Node node) { //전위 : root - left - right
        if (node != null) {
            System.out.print(node.data);
//            System.out.print(' ');
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void inOrder(Node node) { //중위 : left - root - right
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data);
//            System.out.print(' ');
            inOrder(node.right);
        }
    }

    public static void postOrder(Node node) { //후위 : left - right - root
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
//            System.out.print(' ');
        }
    }


    public static void main(String[] args) throws IOException {
        //이진 트리를 입력받아 preorder traversal, inorder traversal, postorder traversal 결과 출력 프로그램 작성하라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] data = new char[3];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                data[j++] = st.nextToken().charAt(0);
            }
            init(data[0], data[1], data[2]);
        }
//        root = (root != null && root.data == 'A') ? root : new Node('A'); // 안전빵 아님(연결 안됨)
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);

    }


}

class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
    }
}