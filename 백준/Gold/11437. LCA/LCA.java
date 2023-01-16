import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int parent[];
    static boolean isVisited[];
    static List<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        isVisited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            String s[] = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            list[A].add(B);
            list[B].add(A);
        }

        parent[1] = 0;
        isVisited[1] = true;
        dfs(1);

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            isVisited = new boolean[N + 1];

            String s[] = br.readLine().split(" ");

            int node1 = Integer.parseInt(s[0]);
            int node2 = Integer.parseInt(s[1]);
            while (node1 > 0) {
                isVisited[node1] = true;
                node1 = parent[node1];
            }
            while (node2 > 0) {
                if (isVisited[node2]) {
                    bw.write(node2 + "\n");
                    break;
                }
                node2 = parent[node2];
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int node) {
        for (int i = 0; i < list[node].size(); i++) {
            if(!isVisited[list[node].get(i)]){
                parent[list[node].get(i)] = node;
                isVisited[list[node].get(i)] = true;
                dfs(list[node].get(i));
            }
        }
    }
}