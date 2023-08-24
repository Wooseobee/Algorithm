import java.io.*;
import java.util.*;

public class Main {

	private static int n, min = Integer.MAX_VALUE;
	private static List[] area;
	private static int[] p, parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		p = new int[n + 1];
		parents = new int[n + 1];
		area = new List[n + 1];

		for (int i = 1; i <= n; i++) {
			area[i] = new ArrayList<>();
		}

		String[] in = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(in[i - 1]);
		}

		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			int k = Integer.parseInt(in[0]);
			for (int j = 0; j < k; j++) {
				area[i + 1].add(Integer.parseInt(in[j + 1]));
			}
		}

		for (int i = 1; i <= n / 2; i++) {
			int[] choice = new int[i];
			comb(0, 1, i, choice, new boolean[n + 1]);
		}

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		br.close();
	}

	private static void comb(int depth, int idx, int max, int[] choice, boolean[] selected) {
		if (depth == max) {
			int[] notChoiced = new int[n - max];
			for (int i = 1, j = 0; i <= n; i++) {
				if (!selected[i]) {
					notChoiced[j++] = i;
				}
			}
			if (canDivide(choice, selected, notChoiced, max)) {
				min = Math.min(min, countPeople(choice, notChoiced));
			}
			return;
		}
		for (int i = idx; i <= n; i++) {
			choice[depth] = i;
			selected[i] = true;
			comb(depth + 1, i + 1, max, choice, selected);
			selected[i] = false;
		}
	}

	private static int countPeople(int[] choice, int[] nonSelected) {
		int totalA = 0, totalB = 0;
		for (int idx : choice) {
			totalA += p[idx];
		}
		for (int idx : nonSelected) {
			totalB += p[idx];
		}
		return Math.abs(totalA - totalB);
	}

	private static boolean canDivide(int[] choice, boolean[] selected, int[] notChoiced, int max) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[n + 1];

		q.add(choice[0]);
		visited[choice[0]] = true;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < max; i++) {
				int next = choice[i];
				if (!visited[next] && area[now].contains(next)) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		
		for (int i = 0; i < max; i++) {
			int now = choice[i];
			if(!visited[now]) return false;
		}

		q.clear();
		visited = new boolean[n + 1];
		
		q.add(notChoiced[0]);
		visited[notChoiced[0]] = true;
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < n - max; i++) {
				int next = notChoiced[i];
				if (!visited[next] && area[now].contains(next)) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		
		for (int i = 0; i < n - max; i++) {
			int now = notChoiced[i];
			if(!visited[now]) return false;
		}
		return true;
	}
}