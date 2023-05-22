import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int j = 1; j <= order.length; j++) {
            stack.push(j);
            while(!stack.isEmpty() && stack.peek() == order[answer]){
                answer++;
                stack.pop();
            }
        }
        
        return answer;
    }
}