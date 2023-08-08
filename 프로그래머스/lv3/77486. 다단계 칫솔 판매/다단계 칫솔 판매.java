import java.util.*;
class Solution {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int n = enroll.length;
		int sell = seller.length;
		int[] answer = new int[n];

		Map<String, String> parentMap = new HashMap<>();
		Map<String, Integer> idxMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			idxMap.put(enroll[i], i);
			parentMap.put(enroll[i], referral[i]);
		}

		for (int i = 0; i < sell; i++) {
			String parent = parentMap.get(seller[i]);
			int forMyMoney = amount[i] * 90;
			int forParentMoney = amount[i] * 10;

			answer[idxMap.get(seller[i])] += forMyMoney;

			while (!parent.equals("-") && forParentMoney >= 1) {
				if (forParentMoney * 10 / 100 < 1) {
					forMyMoney = forParentMoney;
					forParentMoney = 0;
				} else {
					int tmp = forParentMoney;
					forParentMoney = forParentMoney * 10 / 100;
					forMyMoney = tmp - forParentMoney;
				}
				if (!parent.equals("-")) {
					answer[idxMap.get(parent)] += forMyMoney;
				}
				parent = parentMap.getOrDefault(parent, "-");
			}
		}

		return answer;
	}
}