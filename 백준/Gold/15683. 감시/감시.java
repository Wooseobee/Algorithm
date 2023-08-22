import java.io.*;
import java.util.*;

public class Main {

	private static int n, m, cctvNum, min = Integer.MAX_VALUE;
	private static int[][] map;
	private static List<int[]> cctvList = new ArrayList<>();
	private static int[] cctvDirs;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(in[j]);
				if (map[i][j] != 0 && map[i][j] != 6)
					cctvList.add(new int[] { i, j });
			}
		}

		cctvNum = cctvList.size();
		cctvDirs = new int[cctvNum];

		perm(0);
		System.out.println(min);
		br.close();
	}

	private static void perm(int depth) {
		if (depth == cctvNum) {
			setCCTV();
			return;
		}
		for (int i = 0; i < 4; i++) {
			cctvDirs[depth] = i;
			perm(depth + 1);
		}
	}

	private static void setCCTV() {
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			copy[i] = Arrays.copyOf(map[i], m);
		}

		for (int k = 0; k < cctvNum; k++) {
			int[] cctv = cctvList.get(k);
			int i = cctv[0];
			int j = cctv[1];
			int kind = copy[i][j];
			int dir = cctvDirs[k];
			switch (kind) {
			case 1:
				setCCTVbyDir(i, j, dir, copy);
				break;
			case 2:
				setCCTVbyDir(i, j, dir, copy);
				setCCTVbyDir(i, j, (dir + 2) % 4, copy);
				break;
			case 3:
				setCCTVbyDir(i, j, dir, copy);
				setCCTVbyDir(i, j, (dir + 1) % 4, copy);
				break;
			case 4:
				setCCTVbyDir(i, j, (dir + 1) % 4, copy);
				setCCTVbyDir(i, j, (dir + 2) % 4, copy);
				setCCTVbyDir(i, j, (dir + 3) % 4, copy);
				break;
			case 5:
				for (int l = 0; l < 4; l++) {
					setCCTVbyDir(i, j, l, copy);
				}
				break;
			default:
				break;
			}

		}

		min = Math.min(min, countArea(copy));
	}

	private static void setCCTVbyDir(int i, int j, int dir, int[][] map) {
		int nI = i + dx[dir];
		int nJ = j + dy[dir];

		while (in(nI, nJ)) {
			if (map[nI][nJ] == 0) {
				map[nI][nJ] = 7;
			} else if (map[nI][nJ] == 6) {
				break;
			}
			nI = nI + dx[dir];
			nJ = nJ + dy[dir];
		}
	}

	private static boolean in(int nI, int nJ) {
		return nI >= 0 && nJ >= 0 && nI < n && nJ < m;
	}

	private static int countArea(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}

		return cnt;
	}

}