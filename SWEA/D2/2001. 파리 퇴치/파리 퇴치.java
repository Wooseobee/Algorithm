import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int max = 0;
			for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					max = Math.max(max, searchMax(n, m, map, i, j));
				}
			}

			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}

	private static int searchMax(int n, int m, int[][] map, int i, int j) {
		int total = 0;
		for (int i1 = i; i1 < i + m; i1++) {
			for (int j1 = j; j1 < j + m; j1++) {
				total += map[i1][j1];
			}
		}
		return total;
	}
}