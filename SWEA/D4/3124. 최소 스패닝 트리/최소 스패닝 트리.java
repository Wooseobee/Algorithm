import java.io.*;
import java.util.*;

public class Solution {

	private static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 정답을 한번에 출력하기 위해 StringBuilder 사용

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 정점 개수, 간선 개수 입력받기
			String[] in = br.readLine().split(" ");

			int v = Integer.parseInt(in[0]);
			int e = Integer.parseInt(in[1]);
			int cnt = 0;
			long total = 0;

			parents = new int[v + 1];
			for (int i = 1; i <= v; i++) {
				parents[i] = i;
			}
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
			for (int i = 0; i < e; i++) {
				in = br.readLine().split(" ");
				int a = Integer.parseInt(in[0]);
				int b = Integer.parseInt(in[1]);
				int c = Integer.parseInt(in[2]);
				pq.add(new int[] { a, b, c });
			}

			while (!pq.isEmpty()) {
				int[] now = pq.poll();
				int a = now[0];
				int b = now[1];
				int c = now[2];

				if (union(a, b)) {
					total += c;
					if (++cnt == v - 1)
						break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(total).append("\n");
		}

		System.out.println(sb); // 정답 출력
		br.close();
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		else {
			parents[y] = x;
			return true;
		}
	}

	private static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}
}