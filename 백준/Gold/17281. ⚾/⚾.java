import java.io.*;

public class Main {

	private static int n, max = 0;
	private static int[][] info;
	private static int[] order = new int[10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		info = new int[n][10];
		for (int i = 0; i < n; i++) {
			String[] in = br.readLine().split(" ");

			for (int j = 1; j <= 9; j++) {
				info[i][j] = Integer.parseInt(in[j - 1]);
			}
		}
		makeOrder(1, new boolean[10]);
		System.out.println(max);
		br.close();
	}

	private static void makeOrder(int depth, boolean[] visited) {
		if (depth == 10) {
			int score = playGame();
			max = Math.max(max, score);
			return;
		}
		for (int i = 2; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;

				order[depth] = i;
				if (depth == 3) {
					order[4] = 1;
					makeOrder(depth + 2, visited);
				}
				makeOrder(depth + 1, visited);

				visited[i] = false;
			}
		}
	}

	private static int playGame() {
		int score = 0;
		int idx = 1;

		for (int i = 0; i < n; i++) {
			// 아웃카운트
			int outCnt = 0;
			// 1,2,3 루
			int one = 0;
			int two = 0;
			int three = 0;
			while (outCnt < 3) {
				if (idx == 0) idx = 1;
				int result = info[i][order[idx]];
				idx = (idx + 1) % 10;
				switch (result) {
				case 0:
					outCnt++;
					break;
				case 1:
					score += three;
					three = two;
					two = one;
					one = 1;
					break;
				case 2:
					score += three + two;
					three = one;
					two = 1;
					one = 0;
					break;
				case 3:
					score += three + two + one;
					three = 1;
					two = 0;
					one = 0;
					break;
				case 4:
					score += three + two + one + 1;
					three = 0;
					two = 0;
					one = 0;
					break;
				default:
					break;
				}
			}
		}

		return score;
	}

}