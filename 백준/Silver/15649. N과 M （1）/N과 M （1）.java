import java.io.*;

public class Main {
	private static int[] arr;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");

		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);

		arr = new int[m];
		visited = new boolean[n + 1];

		backTracking(0, n, m);
		System.out.println(sb);
	}

	private static void backTracking(int depth, int n, int m) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				arr[depth] = i;
				
				visited[i] = true;
				backTracking(depth + 1, n, m);
				visited[i] = false;
			}
		}
	}
}