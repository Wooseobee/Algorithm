import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");
		int s = Integer.parseInt(in[0]);
		int p = Integer.parseInt(in[1]);

		String dna = br.readLine();

		in = br.readLine().split(" ");
		int[] charCnt = new int[4];
		for (int i = 0; i < 4; i++) {
			charCnt[i] = Integer.parseInt(in[i]);
		}

		int answer = 0;
		int[] window = new int[4];

		for (int i = 0; i < p; i++) {
			countCharacter(dna, window, i, 0);
		}
		if (canMakePassword(window, charCnt)) answer++;

		for (int i = 1; i <= s - p; i++) {
			countCharacter(dna, window, i - 1, 1);
			countCharacter(dna, window, i + p - 1, 0);
			if (canMakePassword(window, charCnt)) answer++;
		}

		System.out.println(answer);
		br.close();
	}

	private static boolean canMakePassword(int[] window, int[] charCnt) {
		for (int j = 0; j < 4; j++) {
			if (window[j] < charCnt[j]) return false;
		}
		return true;
	}

	private static void countCharacter(String dna, int[] window, int i, int flag) {
		flag = (flag == 0 ? 1 : -1);
		switch (dna.charAt(i)) {
		case 'A':
			window[0] += flag;
			break;
		case 'C':
			window[1] += flag;
			break;
		case 'G':
			window[2] += flag;
			break;
		case 'T':
			window[3] += flag;
			break;
		default:
			break;
		}
	}
}