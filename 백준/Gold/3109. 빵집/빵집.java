import java.io.*;

public class Main {

	private static int n, m, cnt = 0;
	private static boolean found;
	private static char[][] map;
	private static int[] dx = { -1, 0, 1 };
	private static int[] dy = { 1, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");

		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);

		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			in = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = in[j].charAt(0);
			}
		}

		for (int i = 0; i < n; i++) {
			found = false;
			dfs(i, 0);
		}
		System.out.println(cnt);
		br.close();
	}

	private static void dfs(int i, int j) {
		if (j == m - 1) {
			cnt++;
			found = true;
			return;
		}

		for (int k = 0; k < 3; k++) {
			if (found)
				return;
			int nI = i + dx[k];
			int nJ = j + dy[k];
			if (nI >= 0 && nJ >= 0 && nI < n && nJ < m && map[nI][nJ] == '.') {
				map[nI][nJ] = 'x';
				dfs(nI, nJ);
			}

		}
	}
}