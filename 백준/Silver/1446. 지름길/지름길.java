import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static class load {
        int start;
        int length;

        public load(int end, int length) {
            this.start = end;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int[] dp = new int[10_001];
        Map<Integer, List<load>> list = new HashMap<>();

        for (int i = 0; i <= d; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);
            if (!list.containsKey(e)) {
                list.put(e, new ArrayList<>());
            }
            list.get(e).add(new load(s, dist));
        }

        for (int i = 1; i <= d; i++) {
            int tmp = dp[i - 1] + 1;
            if (list.containsKey(i)) {
                for (load fastLoad : list.get(i)) {
                    tmp = Math.min(tmp, dp[fastLoad.start] + fastLoad.length);
                }
            }
            dp[i] = tmp;
        }

        System.out.println(dp[d]);

        br.close();
    }
}