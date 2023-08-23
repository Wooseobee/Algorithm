import java.util.*;

class Solution {
    // 8명 모두 세우고 조건에 맞는지 확인 ? 8! 가능
    int answer = 0;
    int n;
    int[] order = new int[8];
    boolean[] visited = new boolean[8];
    List<Character> friends = Arrays.asList('A', 'C', 'F', 'J', 'M', 'N', 'R', 'T');
    
    public int solution(int n, String[] data) {
        this.n = n;
        makeOrder(0, data);
        return answer;
    }
    
    private void makeOrder(int depth, String[] data) {
        if (depth == 8) {
			if (checkCondition(data))
				answer++;
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[depth] = i;
				makeOrder(depth + 1, data);
				visited[i] = false;
			}
		}
    }
    
    private boolean checkCondition(String[] data) {
        for (int i = 0; i < n; i++) {
			char f1 = data[i].charAt(0);
			char f2 = data[i].charAt(2);
			char op = data[i].charAt(3);
			int diff = Character.getNumericValue(data[i].charAt(4));

			int idx1 = 0, friends1 = friends.indexOf(f1);
			int idx2 = 0, friends2 = friends.indexOf(f2);

			for (int j = 0; j < 8; j++) {
				if (order[j] == friends1)
					idx1 = j;
				if (order[j] == friends2)
					idx2 = j;
			}

			switch (op) {
			case '=':
				if (Math.abs(idx1 - idx2) != diff + 1) {
					return false;
				}
				break;
			case '<':
				if (Math.abs(idx1 - idx2) >= diff + 1) {
					return false;
				}
				break;
			case '>':
				if (Math.abs(idx1 - idx2) <= diff + 1) {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return true;
    }
}