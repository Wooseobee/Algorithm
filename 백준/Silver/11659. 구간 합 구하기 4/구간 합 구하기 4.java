import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] in = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);

		int[] dp = new int[n + 1];
		int v;

		in = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			v = Integer.parseInt(in[i - 1]);
			dp[i] = dp[i - 1] + v;
		}

		for (int i = 1; i <= m; i++) {
			in = br.readLine().split(" ");
			int s = Integer.parseInt(in[0]);
			int e = Integer.parseInt(in[1]);

			int sum = dp[e] - dp[s - 1];
			sb.append(sum).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

}