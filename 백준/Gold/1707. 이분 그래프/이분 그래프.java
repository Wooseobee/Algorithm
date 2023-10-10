import java.io.*;
import java.util.*;

public class Main {

	private static int[] visited;
	private static List[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] in = br.readLine().split(" ");
			int v = Integer.parseInt(in[0]);
			int e = Integer.parseInt(in[1]);

			visited = new int[v + 1];
			graph = new List[v + 1];

			for (int j = 1; j <= v; j++) {
				graph[j] = new ArrayList<Integer>();
			}

			for (int j = 0; j < e; j++) {
				in = br.readLine().split(" ");
				int x = Integer.parseInt(in[0]);
				int y = Integer.parseInt(in[1]);

				graph[x].add(y);
				graph[y].add(x);
			}

			for (int j = 1; j <= v; j++) {
				if (visited[j] == 0) {
					dfs(j);
				}
			}

			boolean isTrue = true;
			for (int j = 1; j <= v; j++) {
				int va = visited[j];
				for (int k = 0; k < graph[j].size(); k++) {
					int next = (int) graph[j].get(k);
					if (va == visited[next]) {
						isTrue = false;
						break;
					}
				}
			}
			sb.append(isTrue ? "YES" : "NO").append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static void dfs(int idx) {
		if (visited[idx] == 0)
			visited[idx] = -1;
		for (int i = 0; i < graph[idx].size(); i++) {
			int next = (int) graph[idx].get(i);
			if (visited[next] == 0) {
				if (visited[idx] == -1)
					visited[next] = 1;
				else
					visited[next] = -1;
				dfs(next);
			}
		}
	}
}