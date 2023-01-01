import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add("(");
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop().equals(")")) {
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }

        return true;
    }
}