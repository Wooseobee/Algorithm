import java.io.*;
import java.util.*;

public class Solution {
	private static int n, min;
	private static int[] com, home, order;
	private static int[][] custom;
	private static boolean[] visited;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		com = new int[2];
		home = new int[2];
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			custom = new int[n][2];
			order = new int[n];
			visited = new boolean[n];
			min = Integer.MAX_VALUE;

			String[] in = br.readLine().split(" ");

			com[0] = Integer.parseInt(in[0]);
			com[1] = Integer.parseInt(in[1]);
			home[0] = Integer.parseInt(in[2]);
			home[1] = Integer.parseInt(in[3]);
			for (int j = 0, i = 4; i < n * 2 + 4; i += 2, j++) {
				custom[j][0] = Integer.parseInt(in[i]);
				custom[j][1] = Integer.parseInt(in[i + 1]);
			}

			searchOrder(0);

			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static void searchOrder(int depth) {
		if (depth == n) {
			min = Math.min(min, calculateDist());
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;

				order[depth] = i;
				searchOrder(depth + 1);

				visited[i] = false;
			}
		}
	}

	private static int calculateDist() {
		int dist = 0;
		int sI = com[0];
		int sJ = com[1];
		for (int i = 0; i < n; i++) {
			int nextCustom = order[i];
			dist += Math.abs(sI - custom[nextCustom][0]) + Math.abs(sJ - custom[nextCustom][1]);
			sI = custom[nextCustom][0];
			sJ = custom[nextCustom][1];
		}
		dist += Math.abs(sI - home[0]) + Math.abs(sJ - home[1]);

		return dist;
	}
}