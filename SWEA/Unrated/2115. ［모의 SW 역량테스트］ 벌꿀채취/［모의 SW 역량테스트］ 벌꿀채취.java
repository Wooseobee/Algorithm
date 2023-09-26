import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	private static int n, m, c, max;
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] in = br.readLine().split(" ");

			n = Integer.parseInt(in[0]);
			m = Integer.parseInt(in[1]);
			c = Integer.parseInt(in[2]);
			max = 0;

			map = new int[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				in = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(in[j]);
				}
			}

			comb(0, 0);
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static void comb(int depth, int x) {
		if (depth == 2) {
			max = Math.max(max, findMax());
			return;
		}

		for (int i = x; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				if (!visited[i][j] && !visited[i][j + m - 1]) {
					for (int k = j; k < j + m; k++) {
						visited[i][k] = true;
					}

					comb(depth + 1, i);

					for (int k = j; k < j + m; k++) {
						visited[i][k] = false;
					}
				}
			}
		}
	}

	private static int findMax() {
		int total = 0;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j <= n - m; j++) {
				if (visited[i][j]) {
					for (int k = j; k < j + m; k++) {
						cnt += map[i][k];
					}
					if (cnt > c) {
						total += findBest(0, 0, i, j, 1);
					} else {
						for (int k = j; k < j + m; k++) {
							total += (int) Math.pow(map[i][k], 2);
						}
					}
					j += m - 1;
				}
			}
		}
		return total;
	}

	private static int findBest(int total, int cnt, int i, int j, int depth) {
		if (cnt > c) {
			return total - (int) Math.pow(map[i][j - 1], 2);
		}
		if (depth == m) {
			if (cnt + map[i][j] > c) {
				return total;
			} else {
				return total + (int) Math.pow(map[i][j], 2);
			}
		}

		return Math.max(findBest(total, cnt, i, j + 1, depth + 1),
				findBest(total + (int) Math.pow(map[i][j], 2), cnt + map[i][j], i, j + 1, depth + 1));
	}
}