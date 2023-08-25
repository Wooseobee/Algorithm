import java.io.*;
import java.util.*;

class Solution {

	private static int n, maxCoreSize, minLen, totalCoreSize, cnt, line;
	private static List<int[]> coreList;
	private static int[][] map;
	private static int[] direction;
	private static int[] dx = { -1, 0, 0, 1, 0 };
	private static int[] dy = { 0, -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());

			map = new int[n][n];
			maxCoreSize = 0;
			minLen = Integer.MAX_VALUE;
			coreList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String[] in = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(in[j]);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != 0 && j != 0 && i != n - 1 && j != n - 1) {
						if (map[i][j] == 1) {
							coreList.add(new int[] { i, j });
						}
					}
				}
			}

			totalCoreSize = coreList.size();
			direction = new int[totalCoreSize];
			setDirection(0);

			sb.append("#").append(t).append(" ").append(minLen).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static boolean checkDir(int idx, int dir) {
		int[] now = coreList.get(idx);
		int i = now[0];
		int j = now[1];
		int nI = i + dx[dir];
		int nJ = j + dy[dir];
		while (in(nI, nJ)) {
			if (map[nI][nJ] != 0) {
				return false;
			}
			nI += dx[dir];
			nJ += dy[dir];
		}
		return true;
	}

	private static void setDirection(int depth) {
		if (depth == totalCoreSize) {
			if (maxCoreSize < cnt) {
				maxCoreSize = cnt;
				minLen = line;
			} else if (maxCoreSize == cnt) {
				minLen = Math.min(minLen, line);
			}
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (i == 4 || checkDir(depth, i)) {
				if (i != 4) {
					setMap(depth, i);
				}

				direction[depth] = i;
				setDirection(depth + 1);

				if (i != 4) {
					reSetMap(depth, i);
				}
			}
		}
	}

	private static void reSetMap(int idx, int dir) {
		int[] now = coreList.get(idx);
		int i = now[0];
		int j = now[1];
		int nI = i + dx[dir];
		int nJ = j + dy[dir];
		int l = 0;
		while (in(nI, nJ)) {
			if (map[nI][nJ] != 0) {
				map[nI][nJ] = 0;
			} else {
				return;
			}
			l++;
			nI += dx[dir];
			nJ += dy[dir];
		}
		cnt--;
		line -= l;
	}

	private static void setMap(int idx, int dir) {
		int[] now = coreList.get(idx);
		int i = now[0];
		int j = now[1];
		int nI = i + dx[dir];
		int nJ = j + dy[dir];
		int l = 0;
		while (in(nI, nJ)) {
			if (map[nI][nJ] == 0) {
				map[nI][nJ] = 2;
			} else {
				break;
			}
			l++;
			nI += dx[dir];
			nJ += dy[dir];
		}
		cnt++;
		line += l;
	}

	private static boolean in(int nI, int nJ) {
		return nI >= 0 && nJ >= 0 && nI < n && nJ < n;
	}
}