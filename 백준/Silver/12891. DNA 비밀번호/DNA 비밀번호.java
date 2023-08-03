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
			switch (dna.charAt(i)) {
			case 'A':
				window[0]++;
				break;
			case 'C':
				window[1]++;
				break;
			case 'G':
				window[2]++;
				break;
			case 'T':
				window[3]++;
				break;
			default:
				break;
			}
		}
		boolean canMake = true;
		for (int j = 0; j < 4; j++) {
			if (window[j] < charCnt[j]) {
				canMake = false;
				break;
			}
		}
		if (canMake)
			answer++;

		for (int i = 1; i <= s - p; i++) {
			canMake = true;
			switch (dna.charAt(i - 1)) {
			case 'A':
				window[0]--;
				break;
			case 'C':
				window[1]--;
				break;
			case 'G':
				window[2]--;
				break;
			case 'T':
				window[3]--;
				break;
			default:
				break;
			}
			switch (dna.charAt(i + p - 1)) {
			case 'A':
				window[0]++;
				break;
			case 'C':
				window[1]++;
				break;
			case 'G':
				window[2]++;
				break;
			case 'T':
				window[3]++;
				break;
			default:
				break;
			}
			for (int j = 0; j < 4; j++) {
				if (window[j] < charCnt[j]) {
					canMake = false;
					break;
				}
			}
			if (canMake)
				answer++;
		}
		System.out.println(answer);
		br.close();
	}

}