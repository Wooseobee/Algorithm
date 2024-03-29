import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];

        Stack<Integer> stack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {    // 뒤에서부터 진행
            int num = numbers[i];
            while (!stack.isEmpty() && stack.peek() <= num) {   // top이 현재 숫자보다 클때까지 뽑기
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }
            stack.push(numbers[i]);
        }

        return answer;
    }
}