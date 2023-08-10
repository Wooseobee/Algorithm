import java.io.*;
import java.util.*;

public class Solution {
	private static List<Integer> cardA;
	private static List<Integer> cardB;
	private static int winA;
	private static int winB;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		String[] in;
		for (int test_case = 1; test_case <= T; test_case++) {
			cardA = new ArrayList<>();
			cardB = new ArrayList<>();
			in = br.readLine().split(" ");

			for (int i = 0; i < 9; i++) {
				cardA.add(Integer.parseInt(in[i]));
			}

			for (int i = 1; i <= 18; i++) {
				if (!cardA.contains(i))
					cardB.add(i);
			}

			winA = 0;
			winB = 0;
			countWin(0, 0, 0, new boolean[19]);

			sb.append("#").append(test_case).append(" ").append(winA).append(" ").append(winB).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void countWin(int depth, int totalA, int totalB, boolean[] visited) {
		if (depth == 9) {
			if (totalA > totalB)
				winA++;
			else
				winB++;
			return;
		}
		int a = cardA.get(depth);
		for (int i = 0; i < 9; i++) {
			int b = cardB.get(i);
			if (!visited[b]) {
				visited[b] = true;
				if (a > b) {
					countWin(depth + 1, totalA + a + b, totalB, visited);
				} else {
					countWin(depth + 1, totalA, totalB + a + b, visited);
				}
				visited[b] = false;
			}
		}
	}
}