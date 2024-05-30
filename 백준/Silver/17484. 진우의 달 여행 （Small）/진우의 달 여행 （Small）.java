import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        int[][] map = new int[n][m];
        /**
         * 우측 상단에서 온 것 0번 index
         * 바로 위에서 온 것 1번 index
         * 좌측 상단에서 온 것 2번 index
         */
        int[][][] dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(in[j]);
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 601;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == 0 && j == 2) || (i == m - 1 && j == 0)) {
                    continue;
                }
                dp[0][i][j] = map[0][i];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {   // 이전 방향
                    int now = dp[i][j][k];

                    for (int l = 0; l < 3; l++) {   // 나아갈 방향
                        if ((j == 0 && l == 0) || (j == m - 1 && l == 2) || k == l) {
                            continue;
                        }
                        int next = map[i + 1][j + l - 1];

                        dp[i + 1][j + l - 1][l] = Math.min(dp[i + 1][j + l - 1][l], now + next);
                    }
                }
            }
        }

        int min = 601;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[n - 1][i][j]);
            }
        }

        System.out.println(min);
        br.close();
    }

}