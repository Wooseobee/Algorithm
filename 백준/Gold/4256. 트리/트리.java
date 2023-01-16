import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int preOrder[];
    static int inOrder[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            preOrder = new int[n];
            inOrder = new int[n];

            String s[] = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                preOrder[j] = Integer.parseInt(s[j]);
            }
            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                inOrder[j] = Integer.parseInt(s[j]);
            }

            makePostOrder(0, n, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void makePostOrder(int start, int end, int root) {
        for (int i = start; i < end; i++) {
            if (inOrder[i] == preOrder[root]) {
                makePostOrder(start, i, root + 1);
                makePostOrder(i + 1, end, root + i - start + 1);
                sb.append(preOrder[root] + " ");
            }
        }
    }
}