import java.io.*;

public class Solution {

	static int n, l, max;
	static int[][] food;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		String[] in;
		for (int test_case = 1; test_case <= T; test_case++) {
			in = br.readLine().split(" ");
			n = Integer.parseInt(in[0]);
			l = Integer.parseInt(in[1]);

			food = new int[n][2];
			for (int i = 0; i < n; i++) {
				in = br.readLine().split(" ");
				int t = Integer.parseInt(in[0]);
				int k = Integer.parseInt(in[1]);
				food[i][0] = t;
				food[i][1] = k;
			}

			max = 0;
			makeHambuger(0, 0, 0);

			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void makeHambuger(int depth, int t, int k) {
		if (depth == n) {
			if (k <= l) max = Math.max(max, t);
			return;
		}
		if (k > l) return;
		makeHambuger(depth + 1, t, k);
		makeHambuger(depth + 1, t + food[depth][0], k + food[depth][1]);
	}
}