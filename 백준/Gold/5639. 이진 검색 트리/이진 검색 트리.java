import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }
    }

    static Node root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            makeTree(root, new Node(Integer.parseInt(input)));
        }
        postOrder(root);
        br.close();
    }

    public static void makeTree(Node start, Node input) {
        if (start.num > input.num) {
            if (start.left == null) {
                start.left = input;
            } else {
                makeTree(start.left, input);
            }
        } else {
            if (start.right == null) {
                start.right = input;
            } else {
                makeTree(start.right, input);
            }
        }
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}