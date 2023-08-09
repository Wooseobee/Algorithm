import java.io.*;
import java.util.*;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int n, m, r;
	private static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");

		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		r = Integer.parseInt(in[2]);

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(in[j]);
			}
		}

		String[] op = br.readLine().split(" ");

		for (int i = 0; i < r; i++) {
			switch (Integer.parseInt(op[i])) {
			case 1:
				rotate1();
				break;
			case 2:
				rotate2();
				break;
			case 3:
				rotate3();
				break;
			case 4:
				rotate4();
				break;
			case 5:
				rotate5();
				break;
			case 6:
				rotate6();
				break;
			default:
				break;
			}
		}

		printArray();

		System.out.println(sb);
		br.close();
	}

	private static void printArray() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}

	private static void rotate6() {
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			tmp[i] = Arrays.copyOf(arr[i], m);
		}

		int r = n / 2;
		int c = m / 2;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i < r && j < c) {
					arr[i][j] = tmp[i][j + c];
				} else if (i < r && j >= c) {
					arr[i][j] = tmp[i + r][j];
				} else if (i >= r && j < c) {
					arr[i][j] = tmp[i - r][j];
				} else {
					arr[i][j] = tmp[i][j - c];
				}
			}
		}
	}

	private static void rotate5() {
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			tmp[i] = Arrays.copyOf(arr[i], m);
		}

		int r = n / 2;
		int c = m / 2;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i < r && j < c) {
					arr[i][j] = tmp[i + r][j];
				} else if (i < r && j >= c) {
					arr[i][j] = tmp[i][j - c];
				} else if (i >= r && j < c) {
					arr[i][j] = tmp[i][j + c];
				} else {
					arr[i][j] = tmp[i - r][j];
				}
			}
		}
	}

	private static void rotate4() {
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			tmp[i] = Arrays.copyOf(arr[i], m);
		}

		arr = new int[m][n];
		int temp = n;
		n = m;
		m = temp;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = tmp[j][n - i - 1];
			}
		}
	}

	private static void rotate3() {
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			tmp[i] = Arrays.copyOf(arr[i], m);
		}

		arr = new int[m][n];
		int temp = n;
		n = m;
		m = temp;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = tmp[m - j - 1][i];
			}
		}
	}

	private static void rotate2() {
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			tmp[i] = Arrays.copyOf(arr[i], m);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = tmp[i][m - j - 1];
			}
		}
	}

	private static void rotate1() {
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			tmp[i] = Arrays.copyOf(arr[i], m);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = tmp[n - i - 1][j];
			}
		}
	}
}