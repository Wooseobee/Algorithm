import java.io.*;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static int n, m;
	private static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		arr = new int[m];

		backTracking(0, 1);

		System.out.println(sb);
		br.close();
	}

	private static void backTracking(int depth, int i) {
		if (depth == m) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[j]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int j = i; j <= n; j++) {
			arr[depth] = j;
			backTracking(depth + 1, j + 1);
		}
	}
}
