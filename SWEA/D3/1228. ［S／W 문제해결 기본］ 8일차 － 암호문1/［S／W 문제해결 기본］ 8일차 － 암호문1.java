import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;

		String[] in;
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> list = new LinkedList<>();

			in = br.readLine().split(" ");

			for (int i = 0; i < in.length; i++) {
				list.add(Integer.parseInt(in[i]));
			}

			int cN = Integer.parseInt(br.readLine());

			in = br.readLine().split(" ");
			int idx = 1;
			while (idx < in.length) {
				int x = Integer.parseInt(in[idx++]);
				int y = Integer.parseInt(in[idx++]);

				for (int i = 0; i < y; i++) {
					list.add(x + i, Integer.parseInt(in[idx++]));
				}
				idx++;
			}

			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}