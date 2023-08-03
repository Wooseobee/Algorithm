import java.io.*;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int[] prime = { 2, 3, 5, 7 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < prime.length; i++) {
			backTracking(prime[i], n - 1);
		}
		System.out.println(sb);
		br.close();
	}

	private static void backTracking(int num, int depth) {
		if (depth == 0) {
			sb.append(num).append("\n");
			return;
		}
		for (int i = 1; i < 10; i += 2) {
			if (isPrime(num * 10 + i)) {
				backTracking(num * 10 + i, depth - 1);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num < 2) return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}