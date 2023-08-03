import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = (int) Math.pow(10, n - 1) * 2; i < Math.pow(10, n - 1) * 8; i++) {
			if (isSpecial(i, n))
				sb.append(i).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	private static boolean isSpecial(int i, int n) {
		int idx = (int) Math.pow(10, n - 1);
		int cnt = 0;
		while (idx > 0) {
			int num = i / idx;
			if (!checkNum(num)) {
				return false;
			}
			if (cnt > 0 && !(num % 10 == 1 || num % 10 == 3 || num % 10 == 7 || num % 10 == 9)) {
				return false;
			}
			cnt++;
			idx /= 10;
		}

		return true;
	}

	private static boolean checkNum(int n) {
		if (n < 2 || (n < 10 && !(n == 2 || n == 3 || n == 5 || n == 7))) return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}