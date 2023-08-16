import java.io.*;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static int n;
	private static int[][] video;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		video = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] in = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				video[i][j] = Integer.parseInt(in[j]);
			}
		}

		compression(0, 0, n);
		System.out.println(sb);
		br.close();
	}

	private static void compression(int i, int j, int size) {
		if (canCompress(i, j, size)) {
			sb.append(video[i][j]);
			return;
		}
		int half = size / 2;
		sb.append("(");
		compression(i, j, half);
		compression(i, j + half, half);
		compression(i + half, j, half);
		compression(i + half, j + half, half);
		sb.append(")");
	}

	private static boolean canCompress(int i, int j, int size) {
		int v = video[i][j];
		for (int k = i; k < i + size; k++) {
			for (int l = j; l < j + size; l++) {
				if (video[k][l] != v)
					return false;
			}
		}
		return true;
	}
}