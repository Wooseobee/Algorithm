import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Stack<int[]> stack = new Stack<>();

		String[] in = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(in[i]);
			while (!stack.isEmpty()) {
				int[] top = stack.peek();
				int idx = top[0];
				int h = top[1];

				if (now >= h) {
					stack.pop();
				} else {
					break;
				}
			}
			if (stack.isEmpty()) {
				sb.append(0);
			} else {
				sb.append(stack.peek()[0] + 1);
			}
			sb.append(" ");
			stack.push(new int[] { i, now });
		}

		System.out.println(sb);
		br.close();
	}

}