import java.io.*;
import java.util.*;

public class Main {
	private static int n, m, total = 0, totalIsland = 0;
	private static int[] parent;
	private static int[] dx = { -1, 0, 0, 1 };
	private static int[] dy = { 0, -1, 1, 0 };
	private static int[][] map;
	private static boolean[][] visited;
    private static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(in[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					totalIsland++;
					setIsland(i, j);
				}
			}
		}
		parent = new int[totalIsland + 1];

		for (int i = 1; i <= totalIsland; i++) {
			parent[i] = i;
		}
		
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] >= 1 && !visited[i][j]) {
					findIsland(i, j);
				}
			}
		}
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int i1 = now[0];
            int i2 = now[1];
            int d = now[2];
            
            if(find(i1) != find(i2)) {
                total += d;
                union(i1, i2);
            }
        }
        
        int p = parent[1];
        for (int i = 2; i <= totalIsland; i++) {
			if (p != find(i)) {
				System.out.println("-1");
				br.close();
				return;
			}
		}

		System.out.println(total == 0 ? "-1" : total);
		br.close();
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static void setIsland(int sI, int sJ) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sI, sJ });
		visited[sI][sJ] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int i = now[0];
			int j = now[1];
			map[i][j] = totalIsland;

			for (int k = 0; k < 4; k++) {
				int nI = i + dx[k];
				int nJ = j + dy[k];

				if (in(nI, nJ) && !visited[nI][nJ] && map[nI][nJ] == 1) {
					q.add(new int[] { nI, nJ });
					visited[nI][nJ] = true;
				}
			}
		}
	}

	private static void findIsland(int sI, int sJ) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sI, sJ });
		visited[sI][sJ] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int i = now[0];
			int j = now[1];

			makeBridge(i, j);

			for (int k = 0; k < 4; k++) {
				int nI = i + dx[k];
				int nJ = j + dy[k];

				if (in(nI, nJ) && !visited[nI][nJ] && map[nI][nJ] == map[sI][sJ]) {
					q.add(new int[] { nI, nJ });
					visited[nI][nJ] = true;
				}
			}
		}
	}

	private static void makeBridge(int sI, int sJ) {
		Queue<int[]> q = new LinkedList<>();
		for (int k = 0; k < 4; k++) {
			int nI = sI + dx[k];
			int nJ = sJ + dy[k];

			if (in(nI, nJ) && map[nI][nJ] == 0) {
				q.add(new int[] { nI, nJ, k, 1 });
			}
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int i = now[0];
			int j = now[1];
			int dir = now[2];
			int len = now[3];

			int nI = i + dx[dir];
			int nJ = j + dy[dir];

			if (in(nI, nJ)) {
				if (map[nI][nJ] > 1) {
					if (len >= 2) {
                        pq.add(new int[]{map[sI][sJ], map[nI][nJ], len});
					}
				} else if (map[nI][nJ] == 0) {
					q.add(new int[] { nI, nJ, dir, len + 1 });
				}
			}

		}
	}

	private static boolean in(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < m;
	}

}