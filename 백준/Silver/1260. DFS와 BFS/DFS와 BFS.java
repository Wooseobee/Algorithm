import java.io.*;
import java.util.*;

public class Main {

	private static int n, m, v;
	private static boolean[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		String[] in = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		v = Integer.parseInt(in[2]);

		arr = new boolean[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			in = br.readLine().split(" ");
			int v1 = Integer.parseInt(in[0]);
			int v2 = Integer.parseInt(in[1]);

			arr[v1][v2] = true;
			arr[v2][v1] = true;
		}

		DFS(sb, new boolean[n + 1], v);
		sb.append("\n");
		BFS(sb);
		System.out.println(sb);
		br.close();
	}

	private static void BFS(StringBuffer sb) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[n + 1];
		q.add(v);
		visited[v] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");

			for (int i = 1; i <= n; i++) {
				if (arr[now][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}

	}

	private static void DFS(StringBuffer sb, boolean[] visited, int now) {
		if (visited[now])
			return;
		sb.append(now).append(" ");
		visited[now] = true;
		for (int i = 1; i <= n; i++) {
			if (arr[now][i] && !visited[i]) {
				DFS(sb, visited, i);
			}
		}
	}
}