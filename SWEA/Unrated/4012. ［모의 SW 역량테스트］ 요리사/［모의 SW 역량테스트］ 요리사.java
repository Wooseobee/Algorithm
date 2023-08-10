import java.io.*;

public class Solution {
	static int[] A;
	static int[] B;
	static int[][] food;
	static int n, min, total;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		String[] in;
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());

			A = new int[n / 2];
			B = new int[n / 2];
			food = new int[n][n];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				in = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					food[i][j] = Integer.parseInt(in[j]);
				}
			}

			selectFood(n, 0, 0, new boolean[n]);

			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void selectFood(int n, int depth, int idx, boolean[] selected) {
		if (depth == n / 2) {
			compareAwithB(selected);
			return;
		}
		for (int i = idx; i < n; i++) {
			selected[i] = true;
			selectFood(n, depth + 1, i + 1, selected);
			selected[i] = false;
		}
	}

	private static void compareAwithB(boolean[] selected) {
		int a = 0;
		for (int i = 0, j = 0, k = 0; i < n; i++) {
			if (selected[i])
				A[j++] = i;
			else
				B[k++] = i;
		}
		for (int i = 0; i < n / 2; i++) {
			for (int j = i + 1; j < n / 2; j++) {
				a += food[A[i]][A[j]] + food[A[j]][A[i]];
			}
		}

		int b = 0;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i + 1; j < n / 2; j++) {
				b += food[B[i]][B[j]] + food[B[j]][B[i]];
			}
		}

		min = Math.min(min, Math.abs(a - b));
	}
}