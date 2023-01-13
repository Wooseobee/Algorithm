import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n];

        dfs(0);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx) throws IOException {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[idx] = i + 1;
            dfs(idx + 1);
        }
    }
}