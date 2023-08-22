import java.io.*;
import java.util.*;

public class Main {

	private static int n, m, max = 0;
	private static List[] friends;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");

		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);

		friends = new ArrayList[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			friends[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			in = br.readLine().split(" ");
			int x = Integer.parseInt(in[0]);
			int y = Integer.parseInt(in[1]);
			friends[x].add(y);
			friends[y].add(x);
		}

		for (int i = 0; i < n; i++) {
			if (max >= 5)
				break;
			dfs(i, 1);
		}

		if (max >= 5) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		br.close();
	}

	private static void dfs(int i, int cnt) {
		if(visited[i] || cnt > 5) {
			return;
		}
		max = Math.max(max, cnt);
		visited[i] = true;
		for (int next : (List<Integer>) friends[i]) {
			dfs(next, cnt + 1);
		}
		visited[i] = false;
	}
}