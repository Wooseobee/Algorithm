import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[m];
        visited = new boolean[n];

        dfs(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int start) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;

                arr[depth] = i + 1;
                dfs(depth + 1, i);

                visited[i] = false;
            }
        }
    }
}