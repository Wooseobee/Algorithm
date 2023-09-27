import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] member = new int[n + 1][n + 1];

		String[] in = br.readLine().split(" ");
		int a = Integer.parseInt(in[0]);
		int b = Integer.parseInt(in[1]);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				member[i][j] = 51;
			}
			member[i][i] = 0;
		}

		while (!(a == -1 && b == -1)) {
			member[a][b] = 1;
			member[b][a] = 1;
			in = br.readLine().split(" ");
			a = Integer.parseInt(in[0]);
			b = Integer.parseInt(in[1]);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					member[i][j] = Math.min(member[i][k] + member[k][j], member[i][j]);
				}
			}
		}

		int min = 51;
		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			int max = 0;
			for (int j = 1; j <= n; j++) {
				if (member[i][j] != 51) {
					max = Math.max(max, member[i][j]);
				}
			}
			if (min > max) {
				min = max;
				ans.clear();
				ans.add(i);
			} else if (min == max) {
				ans.add(i);
			}
		}
		Collections.sort(ans);
		System.out.println(min + " " + ans.size());
		for (int i : ans) {
			System.out.print(i + " ");
		}

		br.close();
	}
}