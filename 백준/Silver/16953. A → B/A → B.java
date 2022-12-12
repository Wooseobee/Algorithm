import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long a, b;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);

        dfs(a, 1);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(min);
        }
        br.close();
    }

    public static void dfs(long v, int cnt) {
        if (v > b) {
            return;
        } else if (v < b) {
            dfs(v * 2, cnt + 1);
            dfs(v * 10 + 1, cnt + 1);
        } else {
            if (min > cnt) {
                min = cnt;
            }
        }
    }
}