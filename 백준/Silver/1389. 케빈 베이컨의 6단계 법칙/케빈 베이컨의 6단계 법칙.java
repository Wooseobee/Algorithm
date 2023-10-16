import java.util.*;
import java.io.*;

public class Main {

	private static int n, m;
	private static int[][] users;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);

		users = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				users[i][j] = 101;
			}
		}

		for (int i = 0; i < m; i++) {
			in = br.readLine().split(" ");
			int a = Integer.parseInt(in[0]);
			int b = Integer.parseInt(in[1]);

			users[a][b] = 1;
			users[b][a] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (k != i && i != j) {
						users[i][j] = Math.min(users[i][j], users[i][k] + users[k][j]);
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int p = 1;
		for (int i = 1; i <= n; i++) {
			int total = 0;
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				total += users[i][j];
			}
			if (min > total) {
				p = i;
				min = total;
			}
		}

		System.out.println(p);
		br.close();
	}
}