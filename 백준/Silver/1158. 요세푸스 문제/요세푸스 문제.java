import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] in = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int k = Integer.parseInt(in[1]);

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		sb.append("<");
		int idx = 0;
		while (list.size() > 1) {
			idx = (idx + k - 1) % list.size();
			sb.append(list.get(idx)).append(", ");
			list.remove(idx);
		}
		sb.append(list.get(0)).append(">");

		System.out.println(sb);
		br.close();
	}

}