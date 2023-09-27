import java.util.*;
import java.io.*;

public class Main {
	private static int n, m, k;
	private static final int[] dx = { -1, 0, 0, 1 };
	private static final int[] dy = { 0, -1, 1, 0 };
	private static boolean[][] visited;
	private static int[][] map;

	public static void main(String[] agrs) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		k = Integer.parseInt(in[2]);

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int l = 0; l < k; l++) {
			in = br.readLine().split(" ");
			int x1 = Integer.parseInt(in[0]); // j
			int y1 = n - Integer.parseInt(in[1]) - 1;
			int x2 = Integer.parseInt(in[2]) - 1; // j
			int y2 = n - Integer.parseInt(in[3]);

			for (int i = y2; i <= y1; i++) {
				for (int j = x1; j <= x2; j++) {
					map[i][j] = 1;
				}
			}
		}

		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					list.add(bfs(i, j));
					cnt++;
				}
			}
		}

		Collections.sort(list);
		System.out.println(cnt);
		for (int i : list) {
			System.out.print(i + " ");
		}

		br.close();
	}

	private static int bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		visited[i][j] = true;
		int total = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nI = now[0];
			int nJ = now[1];

			for (int l = 0; l < 4; l++) {
				int newI = nI + dx[l];
				int newJ = nJ + dy[l];
				if (in(newI, newJ) && !visited[newI][newJ] && map[newI][newJ] == 0) {
					q.add(new int[] { newI, newJ });
					visited[newI][newJ] = true;
					total++;
				}
			}
		}
		return total;
	}

	private static boolean in(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < m;
	}
}