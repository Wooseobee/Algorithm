import java.io.*;

public class Solution {

	private static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			String[] in = br.readLine().split(" ");
			int n = Integer.parseInt(in[0]);
			int m = Integer.parseInt(in[1]);

			parents = new int[n + 1];
			for (int j = 1; j <= n; j++) {
				parents[j] = j;
			}
			sb.append("#").append(i).append(" ");
			for (int j = 0; j < m; j++) {
				in = br.readLine().split(" ");
				int op = Integer.parseInt(in[0]);
				int a = Integer.parseInt(in[1]);
				int b = Integer.parseInt(in[2]);
				switch (op) {
				case 0:
					union(a, b);
					break;
				case 1:
					if (find(a) == find(b))
						sb.append(1);
					else
						sb.append(0);
					break;
				default:
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parents[b] = a;
		}
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

}