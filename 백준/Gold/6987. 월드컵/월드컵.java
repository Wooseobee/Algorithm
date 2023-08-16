import java.io.*;

public class Main {

	private static int[][] match;
	private static boolean[] can;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		can = new boolean[4];
		for (int i = 0; i < 4; i++) {
			String[] in = br.readLine().split(" ");
			match = new int[6][3];

			for (int j = 0, l = 0; l < 18; j++) {
				for (int k = 0; k < 3; k++) {
					match[j][k] = Integer.parseInt(in[l++]);
				}
			}
			matching(0, 1, i);
			if (can[i]) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append(" ");
		}
		System.out.println(sb);
		br.close();

	}

	private static void matching(int t1, int t2, int idx) {
		if (t2 == 6) {
			if (t1 < 4) {
				matching(t1 + 1, t1 + 2, idx);
			} else {
				boolean canMatch = true;
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 3; j++) {
						if (match[i][j] != 0)
							canMatch = false;
					}
				}
				if(canMatch) can[idx] = true;
			}
			return;
		}

        for (int j = 0; j < 3; j++) {
            if (match[t1][j] > 0 && match[t2][3 - j - 1] > 0) {
                match[t1][j]--;
                match[t2][3 - j - 1]--;
                matching(t1, t2 + 1, idx);
                match[t1][j]++;
                match[t2][3 - j - 1]++;
            }
        }
	}
}