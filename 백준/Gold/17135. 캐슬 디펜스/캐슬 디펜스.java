import java.io.*;
import java.util.*;

public class Main {

	private static int n, m, d, max = 0;
	private static int[] archer = new int[3];
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		d = Integer.parseInt(in[2]);

		map = new int[n + 1][m];

		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(in[j]);
			}
		}

		setArcher(0, 0);
		System.out.println(max);
		br.close();
	}

	private static void setArcher(int depth, int idx) {
		if (depth == 3) {
			playGame();
			return;
		}
		for (int i = idx; i < m; i++) {
			archer[depth] = i;
			setArcher(depth + 1, i + 1);
		}
	}

	private static void playGame() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		Set<String> killList = new HashSet<>();
		int[][] tmpMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			tmpMap[i] = Arrays.copyOf(map[i], m);
		}

		for (int i = 0; i < 3; i++) {
			q.add(new int[] { n, archer[i], i, 1 });
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int i = now[0];
			int j = now[1];
			int order = now[2]; // 아처 순번
			int round = now[3];

			int nI = i - 1;
			int nJ = j;
			int dist = 1;
			boolean found = false;

			PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {
				if (o1[2] == o2[2]) {
					return o1[1] - o2[1];
				}
				return o1[2] - o2[2];
			});

			while (nI >= 0 && nJ < m && dist <= d && !found) {
				int tmpDist = dist;
				for (int k = 0; tmpDist <= d; k++) {
					if (nJ - k >= 0 && tmpMap[nI][nJ - k] == 1) {
						pq.add(new int[] { nI, nJ - k, tmpDist });
					}
					if (nJ + k < m && tmpMap[nI][nJ + k] == 1) {
						pq.add(new int[] { nI, nJ + k, tmpDist });
					}
					tmpDist = Math.abs(i - nI) + Math.abs(j - nJ) + k + 1;
				}
				nI--;
				dist++;
			}

			if (i - 1 > 0) {
				q.add(new int[] { i - 1, j, order, round + 1 });
			}

			if (!pq.isEmpty()) {
				int[] killed = pq.poll();
				killList.add(killed[0] + " " + killed[1]);
			}

			if (order == 2) {
				for (String kL : killList) {
					String[] coord = kL.split(" ");
					tmpMap[Integer.parseInt(coord[0])][Integer.parseInt(coord[1])] = 0;
				}
			}
		}
		max = Math.max(max, killList.size());
	}
}