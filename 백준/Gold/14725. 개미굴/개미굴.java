import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    private static class Node {
        Map<String, Node> childs = new HashMap<>();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Node root = new Node();

        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            int size = Integer.parseInt(in[0]);
            Node cur = root;
            for (int j = 0; j < size; j++) {
                String s = in[j + 1];
                if (!cur.childs.containsKey(s)) {
                    cur.childs.put(s, new Node());
                }
                cur = cur.childs.get(s);
            }
        }

        print(root, "");
        System.out.println(sb);
        br.close();
    }

    private static void print(Node cur, String bar) {
        Object[] array = cur.childs.keySet().toArray();
        Arrays.sort(array);

        for (Object s : array) {
            sb.append(bar).append(s).append("\n");
            print(cur.childs.get(s), bar + "--");
        }
    }
}
