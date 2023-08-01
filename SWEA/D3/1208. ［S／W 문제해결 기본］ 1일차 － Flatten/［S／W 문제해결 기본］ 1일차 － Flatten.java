import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = 10;

		int[] arr = new int[100];

		for (int test_case = 1; test_case <= T; test_case++) {

			int dump = sc.nextInt();

			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}

			while (dump > 0) {
				int[] h = searchHeight(arr);
				setHeight(arr, h[3], h[1]);
				dump--;
			}

			int[] h = searchHeight(arr);

			sb.append("#" + test_case + " " + (h[2] - h[0]) + "\n");
		}
		System.out.println(sb);
	}

	public static void setHeight(int[] arr, int high, int low) {
		arr[high]--;
		arr[low]++;
	}

	public static int[] searchHeight(int[] arr) {
		int[] h = new int[4];
		h[0] = 100;

		for (int i = 0; i < arr.length; i++) {
			if (h[2] < arr[i]) {
				h[2] = arr[i];
				h[3] = i;
			}
			if (h[0] > arr[i]) {
				h[0] = arr[i];
				h[1] = i;
			}
		}
		return h;
	}
}