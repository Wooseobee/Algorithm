import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for (int v : arr) {
            if (stack.isEmpty()) stack.add(v);
            else if (stack.peek() != v) stack.add(v);
        }

        int[] answer = new int[stack.size()];

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}