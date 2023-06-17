import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        for (int i : ingredient) {
            if (i == 1) {
                while (!stack.isEmpty() && list.size() < 3) {
                    list.add(stack.pop());
                }
                if (list.size() == 3) {
                    if (list.get(0) == 3 && list.get(1) == 2 && list.get(2) == 1) {
                        answer++;
                        list.clear();
                        continue;
                    }
                }
                for (int j = list.size() - 1; j >= 0; j--) {
                    stack.add(list.get(j));
                }
                list.clear();
            }
            stack.add(i);
        }
        return answer;
    }
}