import java.io.*;

public class Main {

	private static int[][] paper = new int[100][100];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] in = br.readLine().split(" ");
			int x = Integer.parseInt(in[0]);
			int y = Integer.parseInt(in[1]);

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					paper[j][k] = 1;
				}
			}
		}

		int total = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				total += paper[i][j];
			}
		}
		System.out.println(total);
		br.close();

	}

}