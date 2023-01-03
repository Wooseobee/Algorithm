import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[m];
        visited = new boolean[n];

        dfs(0);
        
        br.close();
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {

                visited[i] = true;

                arr[depth] = i + 1;
                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }
}