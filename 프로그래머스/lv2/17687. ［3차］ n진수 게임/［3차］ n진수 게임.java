import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        Map<Integer, String> map = new HashMap<>();
        char ch = 'A';
        for (int i = 10; i <= 15; i++) {
            map.put(i, String.valueOf(ch));
            ch++;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1, j = 0; i <= m * t; i++) {   // i: 말할 차례, j: 말해야 하는 숫자
            if (stack.isEmpty()) {
                changeNum(n, j++, stack);
            }
            int num = stack.pop();
            if (i % m == p % m) {
                sb.append(map.getOrDefault(num, String.valueOf(num)));
            }
        }

        return sb.toString();
    }

    private static void changeNum(int n, int j, Stack<Integer> stack) {
        while (j >= n) {
            stack.push(j % n);
            j /= n;
        }
        stack.push(j);
    }
}