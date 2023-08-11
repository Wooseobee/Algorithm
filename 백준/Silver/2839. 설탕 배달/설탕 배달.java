import java.io.*;

public class Main {
	private static int n, min = 1_667;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int min = 1_667;

		// 5킬로그램 0개부터 n / 5개 까지 탐색
		for (int i = 0; i <= n / 5; i++) {
			int kilo = 5 * i;
			int remain = n - kilo;
			if (remain % 3 == 0) {
				min = Math.min(min, i + remain / 3);
			}
		}
		System.out.println(min == 1_667 ? -1 : min);
		br.close();
	}

}