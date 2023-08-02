import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] in = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);

		int[][] arr = new int[n + 1][n + 1];
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			in = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(in[j - 1]);
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			in = br.readLine().split(" ");
			int x1 = Integer.parseInt(in[0]);
			int y1 = Integer.parseInt(in[1]);
			int x2 = Integer.parseInt(in[2]);
			int y2 = Integer.parseInt(in[3]);

			int sum = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}