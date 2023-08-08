import java.io.*;
import java.util.*;

public class Main {
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] in = br.readLine().split(" ");

		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);
		int r = Integer.parseInt(in[2]);

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(in[j]);
			}
		}

		for (int i = 0; i < r; i++) {
			rotate(arr, n, m);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void rotate(int[][] arr, int n, int m) {
		int s = Math.min(n / 2, m / 2);

		for (int i = 0, j = 0; i < s; i++, j++) {
			int tmp = arr[i][j];

			int prevI = i, prevJ = j;
			int dir = 0;
			int nowI = i + dx[dir], nowJ = j + dy[dir];

			while (!(nowI == i && nowJ == j)) {
				arr[prevI][prevJ] = arr[nowI][nowJ];
				prevI = nowI;
				prevJ = nowJ;

				int newI = nowI + dx[dir];
				int newJ = nowJ + dy[dir];

				if (!(newI >= i && newJ >= j && newI < n - i && newJ < m - j)) {
					dir = (dir + 1) % 4;
				}
				nowI += dx[dir];
				nowJ += dy[dir];
			}

			arr[prevI][prevJ] = tmp;
		}

	}

}