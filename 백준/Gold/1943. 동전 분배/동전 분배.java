import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            int total = 0;
            int n = Integer.parseInt(br.readLine());
            int[] cost = new int[n];
            int[] cnt = new int[n];
            for (int j = 0; j < n; j++) {
                String[] in = br.readLine().split(" ");
                cost[j] = Integer.parseInt(in[0]);
                cnt[j] = Integer.parseInt(in[1]);
                total += cost[j] * cnt[j];
            }

            if (total % 2 != 0) {
                System.out.println(0);
                continue;
            }

            int target = total / 2;
            boolean[] money = new boolean[target + 1];
            money[0] = true;

            for (int j = 0; j < n; j++) {
                for (int k = target; k >= 0; k--) {
                    if (money[k]) {
                        for (int l = 1; l <= cnt[j] && k + l * cost[j] <= target; l++) {
                            money[k + l * cost[j]] = true;
                        }
                    }
                }
            }

            if (money[target]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        br.close();
    }

}
