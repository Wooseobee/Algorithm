import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];

        dfs(0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx) throws IOException {
        if (idx == n) {
            for (int i = 0; i < n; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;

                arr[idx] = i + 1;
                dfs(idx + 1);

                visited[i] = false;
            }
        }
    }
}