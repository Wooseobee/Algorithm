import java.io.*;

public class Main {
	private static int[] switches;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		switches = new int[n];
		String[] in = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			switches[i] = Integer.parseInt(in[i]);
		}

		int s = Integer.parseInt(br.readLine());

		for (int i = 0; i < s; i++) {
			in = br.readLine().split(" ");
			changeSwitches(Integer.parseInt(in[0]), Integer.parseInt(in[1]) - 1);
		}
		for (int i = 0; i < switches.length; i++) {
			if (i != 0 && i % 20 == 0) {
				System.out.println();
			}
			System.out.print(switches[i] + " ");
		}
	}

	private static void changeSwitches(int s, int num) {
		switch (s) {
		case 1:
			for (int i = num; i < switches.length; i += (num + 1)) {
				switches[i] = switches[i] == 0 ? 1 : 0;
			}
			break;
		case 2:
			int idx = 1;
			switches[num] = switches[num] == 0 ? 1 : 0;
			while (num - idx >= 0 && num + idx < switches.length && switches[num - idx] == switches[num + idx]) {
				switches[num - idx] = switches[num - idx] == 0 ? 1 : 0;
				switches[num + idx] = switches[num + idx] == 0 ? 1 : 0;
				idx++;
			}
			break;
		default:
			break;
		}
	}
}