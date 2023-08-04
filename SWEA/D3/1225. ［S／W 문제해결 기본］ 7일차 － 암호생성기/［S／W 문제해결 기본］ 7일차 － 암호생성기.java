import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;

		String[] in;
		Deque<Integer> q = new ArrayDeque<>();
		for (int test_case = 1; test_case <= T; test_case++) {
			int t = Integer.parseInt(br.readLine());
			in = br.readLine().split(" ");

			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(in[i]));
			}

			int minus = 1;
			while (q.peekLast() != 0) {
				int first = q.poll() - minus++;
				if (first < 0) {
					q.offer(0);
				} else {
					q.offer(first);
				}
				minus = (minus > 5 ? 1 : minus);
			}

			sb.append("#").append(t);
			while (!q.isEmpty()) {
				sb.append(" ").append(q.poll());
			}
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

}