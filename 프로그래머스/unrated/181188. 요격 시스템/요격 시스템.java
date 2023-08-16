import java.util.*;

class Solution {
	public int solution(int[][] targets) {
		int answer = 0;
		double lastLaser = -1;

		Arrays.sort(targets, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		for (int[] target : targets) {
			int s = target[0];
			int e = target[1];

			if (lastLaser < s) {
				answer++;
				lastLaser = e - 0.1;
			}
		}

		return answer;
	}
}