import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int n, s;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        arr = new int[n];

        input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        dfs(0, 0);
        System.out.println(s == 0 ? cnt - 1 : cnt);
        br.close();
    }

    public static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) cnt++;
            return;
        }

        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}