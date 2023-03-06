import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();

        int len = number.length();
        int cnt = k;
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(String.valueOf(number.charAt(i)));
            while (cnt > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                cnt--;
            }
            if (stack.size() < len - k) {
                stack.add(num);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}