import java.io.*;
import java.util.*;

public class Solution {
	private static int[] dx = { -1, 0, 0, 1 };
	private static int[] dy = { 0, -1, 1, 0 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			int[][] room = new int[n][n];
			int roomNum = 1_000;
			int max = 1;
			
			String[] in;
			for (int i = 0; i < n; i++) {
				in = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					room[i][j] = Integer.parseInt(in[j]);
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int canMove = bfs(n, room, i, j);
					if (canMove == max) {
						if (roomNum > room[i][j]) {
							roomNum = room[i][j];
						}
					} else if (canMove > max) {
						max = canMove;
						roomNum = room[i][j];
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(roomNum).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

	private static int bfs(int n, int[][] room, int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		q.add(new int[] { i, j, 1 });
		int max = 1;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			max = Math.max(max, now[2]);

			for(int d = 0 ; d < 4; d++) {
				int nI = now[0] + dx[d];
				int nJ = now[1] + dy[d];
				
				if (nI>=0 && nJ>=0 && nI<n && nJ<n && !visited[nI][nJ] && room[nI][nJ] == room[now[0]][now[1]] + 1) {
					q.add(new int[] {nI,nJ, now[2] + 1});
					visited[nI][nJ] = true;
				}
			}
		}

		return max;
	}

}