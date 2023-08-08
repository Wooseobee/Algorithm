import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		String[] in;
		for (int test_case = 1; test_case <= T; test_case++) {
			int max = -1;
			in = br.readLine().split(" ");
			int n = Integer.parseInt(in[0]);
			int m = Integer.parseInt(in[1]);
			int[] arr = new int[n];

			in = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(in[i]);
			}

			Arrays.sort(arr);
			int l = 0;
			int r = n - 1;
			while (l < r) {
				int total = arr[l] + arr[r];
				if (total > m) {
					r--;
				} else if (total == m) {
					max = m;
					break;
				} else {
					max = Math.max(max, total);
					l++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}