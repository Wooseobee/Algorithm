import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] answer = new int[6];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        while (true) {
            String[] s = br.readLine().split(" ");
            int k = Integer.parseInt(s[0]);

            if (k == 0) break;

            arr = new int[k];
            visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(s[i + 1]);
            }

            dfs(0, 0);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int start) throws IOException {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(answer[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;

                answer[depth] = arr[i];
                dfs(depth + 1, i);

                visited[i] = false;
            }
        }
    }
}