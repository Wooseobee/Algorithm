import java.util.*;

public class Solution {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(sc.nextLine());
			char[] tree = new char[n+1];
			List<Integer> list = new ArrayList<>();
			String[] in;
			for(int i = 1; i<=n;i++) {
				in = sc.nextLine().split(" ");
				int idx = Integer.parseInt(in[0]);
				tree[idx] = in[1].charAt(0);
				if (Character.isDigit(tree[idx])) {
					list.add(idx);
				}
			}
			
			int ans = checkCanCal(list, n) ? 1 : 0;
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
    
	private static boolean checkCanCal(List<Integer> list, int n) {
		for(int idx : list) {
			if(idx * 2 <= n) return false;
		}
		return true;
	}
}