import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int parent[] = new int[N + 1];
            boolean isVisited[] = new boolean[N + 1];

            for (int j = 1; j < N ; j++) {
                String s[] = br.readLine().split(" ");
                int A = Integer.parseInt(s[0]);
                int B = Integer.parseInt(s[1]);
                parent[B] = A;
            }

            String s[] = br.readLine().split(" ");
            int node1 = Integer.parseInt(s[0]);
            int node2 = Integer.parseInt(s[1]);
            while (node1 > 0) {
                isVisited[node1] = true;
                node1 = parent[node1];
            }
            while (node2 > 0) {
                if (isVisited[node2] == true) {
                    System.out.println(node2);
                    break;
                }
                node2 = parent[node2];
            }
        }
        br.close();
    }
}