import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static List<Node>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < N + 1; i++) {
            String s[] = br.readLine().split(" ");

            int root = s[0].charAt(0) - 'A' + 1;
            int left = s[1].charAt(0) - 'A' + 1;
            int right = s[2].charAt(0) - 'A' + 1;

            list[root].add(new Node(left, right));
        }

        br.close();
        preorder(1);
        System.out.println(sb);
        sb.setLength(0);
        inorder(1);
        System.out.println(sb);
        sb.setLength(0);
        postorder(1);
        System.out.println(sb);
    }

    static void preorder(int root) {
        for (Node node : list[root]) {
            sb.append((char)(root + 'A' - 1));
            if (node.left != (int) (('.') - 'A' + 1)) {
                preorder(node.left);
            }
            if (node.right != (int) (('.') - 'A' + 1)) {
                preorder(node.right);
            }
        }
    }

    static void inorder(int root) {
        for (Node node : list[root]) {
            if (node.left != (int) (('.') - 'A' + 1)) {
                inorder(node.left);
            }
            sb.append((char)(root + 'A' - 1));
            if (node.right != (int) (('.') - 'A' + 1)) {
                inorder(node.right);
            }
        }
    }

    static void postorder(int root) {
        for (Node node : list[root]) {
            if (node.left != (int) (('.') - 'A' + 1)) {
                postorder(node.left);
            }
            if (node.right != (int) (('.') - 'A' + 1)) {
                postorder(node.right);
            }
            sb.append((char)(root + 'A' - 1));
        }
    }
}