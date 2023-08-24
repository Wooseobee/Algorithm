import java.io.*;
import java.util.*;

public class Main {

	private static int V, e, k;
	private static List[] list;
	private static int[] dist;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] in = br.readLine().split(" ");
		V = Integer.parseInt(in[0]);
		e = Integer.parseInt(in[1]);
		k = Integer.parseInt(br.readLine());

		list = new List[V + 1];
		visited = new boolean[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<int[]>();
		}
		for (int i = 0; i < e; i++) {
			in = br.readLine().split(" ");
			int u = Integer.parseInt(in[0]);
			int v = Integer.parseInt(in[1]);
			int w = Integer.parseInt(in[2]);

			list[u].add(new int[] { v, w });
		}

		dist = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[k] = 0;

		dijkstra();
		for (int i = 1; i <= V; i++) {
			int d = dist[i];
			sb.append(d == Integer.MAX_VALUE ? "INF" : d).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
    
    private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { k, 0 });

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int nowV = now[0];
			if(!visited[nowV]) visited[nowV] = true;
			else continue;

			for (int[] next : (ArrayList<int[]>) list[now[0]]) {
				int nextV = next[0];
				int nextW = next[1];
				int W = dist[nowV] + nextW;
				if (dist[nextV] > W) {
					pq.add(new int[] {nextV, W});
					dist[nextV] = W;
				}
			}
		}
	}
}