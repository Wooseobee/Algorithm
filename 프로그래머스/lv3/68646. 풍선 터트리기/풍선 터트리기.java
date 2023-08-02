import java.util.*;
class Solution {
    class Num {
		int idx;
		int v;

		public Num(int idx, int v) {
			this.idx = idx;
			this.v = v;
		}
	}

	public int solution(int[] a) {
		int answer = 0;
		Num[] arr = new Num[a.length];

		for (int i = 0; i < a.length; i++) {
			arr[i] = new Num(i, a[i]);
		}

		Arrays.sort(arr, (o1, o2) -> o1.v - o2.v);

		int maxIdx = 0;
		int minIdx = 1_000_000;
		for (int i = 0; i < arr.length; i++) {
			Num n = arr[i];
			if (n.idx > maxIdx || n.idx < minIdx) {
				answer++;
			}
			maxIdx = Math.max(maxIdx, n.idx);
			minIdx = Math.min(minIdx, n.idx);

		}

		return answer;
	}
}