import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (int j = 1; i < order.length && j <= order.length; j++) {
            if (order[i] == j) {
                answer++;
                i++;
            } else {
                if (!stack.isEmpty() && stack.peek() == order[i]) {
                    answer++;
                    i++;
                    stack.pop();
                    j--;
                } else {
                    stack.push(j);
                }
            }
        }
        while (!stack.isEmpty()) {
            if (order[i] == stack.peek()) {
                answer++;
                i++;
                stack.pop();
            } else {
                break;
            }
        }
        return answer;
    }
}