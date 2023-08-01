import java.util.*;
import java.io.*;

class Solution {
	private static int[] dx = { -1, 1, 0 };
	private static int[] dy = { 0, 0, -1 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = 10;

		int[][] map = new int[100][100];
		boolean[][] visited = new boolean[100][100];
		for (int test_case = 1; test_case <= T; test_case++) {
			int t = sc.nextInt();

			for (int i = 0; i < 100; i++) {
				Arrays.fill(visited[i], false);
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int i = 99;
			int j = searchEnd(map);

			while (i > 0) {
				int newJ, newI;

				visited[i][j] = true;
				for (int d = 0; d < 3; d++) {
					newI = i + dy[d];
					newJ = j + dx[d];
					if (newJ >= 0 && newJ < 100 && !visited[newI][newJ] && map[newI][newJ] == 1) {
						i = newI;
						j = newJ;
						break;
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(j).append("\n");
		}
		System.out.println(sb);
	}

	private static int searchEnd(int[][] map) {
		for (int i = 0; i < 100; i++) {
			if (map[99][i] == 2) {
				return i;
			}
		}
		return 0;
	}
}