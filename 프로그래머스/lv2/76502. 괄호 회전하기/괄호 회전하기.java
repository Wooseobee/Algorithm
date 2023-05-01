import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            char ch = arr[0];
            for (int j = 1; j < len; j++) {
                arr[j - 1] = arr[j];
            }
            arr[len - 1] = ch;
            if (check(arr)) answer++;

        }

        return answer;
    }

    private static boolean check(char[] arr) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) stack.push(arr[i]);
            else {
                char top = stack.peek();
                char first = arr[i];
                switch (first) {
                    case '[':
                    case '{':
                    case '(':
                        stack.push(first);
                        break;
                    case ']':
                        if (top != '[') return false;
                        stack.pop();
                        break;
                    case '}':
                        if (top != '{') return false;
                        stack.pop();
                        break;
                    case ')':
                        if (top != '(') return false;
                        stack.pop();
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}