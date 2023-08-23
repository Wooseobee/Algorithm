import java.io.*;
import java.util.*;

public class Solution {

	private static int n;
	private static double total;
	private static double E;
	private static boolean[] visited;
	private static int[][] island;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());

			island = new int[n][2];
			visited = new boolean[n];
			total = 0;

			for (int j = 0; j < 2; j++) {
				String[] in = br.readLine().split(" ");
				for (int k = 0; k < n; k++) {
					island[k][j] = Integer.parseInt(in[k]);
				}
			}

			E = Double.parseDouble(br.readLine());

			PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1[1], o2[1]));

			int idx = 0;
			pq.add(new double[] { idx, 0.0 });

			while (!pq.isEmpty()) {
				double[] now = pq.poll();
				idx = (int) now[0];
				if (visited[idx])
					continue;
				int x = (int) island[idx][0];
				int y = (int) island[idx][1];
				double cost = now[1];
				visited[idx] = true;
				total += cost;

				for (int j = 0; j < n; j++) {
					if (!visited[j]) {
						int nX = island[j][0];
						int nY = island[j][1];

						double l = Math.sqrt(Math.pow(Math.abs(x - nX), 2) + Math.pow(Math.abs(y - nY), 2));
						double c = E * Math.pow(l, 2);
						pq.add(new double[] { j, c });
					}
				}
			}
			sb.append("#").append(i).append(" ").append(Math.round(total)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}