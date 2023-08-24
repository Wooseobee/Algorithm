import java.io.*;
import java.util.*;

public class Solution {

	private static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 정답을 한번에 출력하기 위해 StringBuilder 사용

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 정점 개수, 간선 개수 입력받기
			String[] in = br.readLine().split(" ");

			int v = Integer.parseInt(in[0]);
			int e = Integer.parseInt(in[1]);
			long total = 0;

			boolean[] visited = new boolean[v + 1];

			List[] nodes = new List[v + 1];
			for (int i = 1; i <= v; i++) {
				nodes[i] = new ArrayList<Node>();
			}
			for (int i = 0; i < e; i++) {
				in = br.readLine().split(" ");
				int a = Integer.parseInt(in[0]);
				int b = Integer.parseInt(in[1]);
				int c = Integer.parseInt(in[2]);

				nodes[a].add(new Node(b, c));
				nodes[b].add(new Node(a, c));
			}

			PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
			pq.add(new Node(1, 0));
			int cnt = 0;
			while (!pq.isEmpty()) {
				Node now = pq.poll();
				int a = now.v;
				int c = now.w;

				if (visited[a]) continue;
				total += c;
				visited[a] = true;
				if(++cnt == v) break;

				for (Node next : (ArrayList<Node>) nodes[a]) {
					if (!visited[next.v]) {
						pq.add(new Node(next.v, next.w));
					}
				}
			}

			sb.append("#").append(t).append(" ").append(total).append("\n");
		}

		System.out.println(sb); // 정답 출력
		br.close();
	}
}