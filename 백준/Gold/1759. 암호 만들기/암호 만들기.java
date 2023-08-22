import java.io.*;
import java.util.*;

public class Main {

	private static int l, c, vo = 0, co = 0;
	private static char[] alphabet;
	private static int[] choice;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");
		l = Integer.parseInt(in[0]);
		c = Integer.parseInt(in[1]);

		choice = new int[l];
		alphabet = new char[c];

		in = br.readLine().split(" ");
		for (int i = 0; i < c; i++) {
			alphabet[i] = in[i].charAt(0);
		}

		Arrays.sort(alphabet);
		makePassword(0, 0);

		System.out.println(sb);
		br.close();
	}

	private static void makePassword(int depth, int idx) {
		if (depth == l) {
			if (vo >= 1 && co >= 2) {
				appendPassword();
			}
			return;
		}
		for (int i = idx; i < c; i++) {
			choice[depth] = i;
			if (alphabet[i] == 'a' || alphabet[i] == 'e' || alphabet[i] == 'i' || alphabet[i] == 'o' || alphabet[i] == 'u') {
				vo++;
			} else {
				co++;
			}
			makePassword(depth + 1, i + 1);
			if (alphabet[i] == 'a' || alphabet[i] == 'e' || alphabet[i] == 'i' || alphabet[i] == 'o' || alphabet[i] == 'u') {
				vo--;
			} else {
				co--;
			}
		}
	}

	private static void appendPassword() {
		for (int i = 0; i < l; i++) {
			sb.append(alphabet[choice[i]]);
		}
		sb.append("\n");
	}
}