import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;
			}
			return Math.abs(o1) - Math.abs(o2);
		});

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());

			switch (x) {
			case 0:
				if (pq.isEmpty()) {
					sb.append("0");
				} else {
					sb.append(pq.poll());
				}
				sb.append("\n");
				break;
			default:
				pq.add(x);
				break;
			}
		}
		System.out.println(sb);
		br.close();
	}

}