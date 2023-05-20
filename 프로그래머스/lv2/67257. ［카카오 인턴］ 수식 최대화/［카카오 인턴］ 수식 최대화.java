import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static char[] priority;
    static List<Character> opList = new ArrayList<>();
    static boolean[] visited;
    static long max = Long.MIN_VALUE;

    public long solution(String expression) {
        String operators = expression.replaceAll("[0-9]", "");

        for (int i = 0; i < operators.length(); i++) {
            if (!opList.contains(operators.charAt(i))) opList.add(operators.charAt(i));
        }

        priority = new char[opList.size()];
        visited = new boolean[opList.size()];

        makePriority(0, opList.size(), expression);
        return max;
    }

    private static void makePriority(int depth, int size, String expression) {
        if (depth == priority.length) {
            calculate(expression);
            return;
        }
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;

                priority[depth] = opList.get(i);
                makePriority(depth + 1, size, expression);

                visited[i] = false;
            }
        }
    }

    private static void calculate(String expression) {
        List<String> operands = Arrays.stream(expression.split("[*+-]")).collect(Collectors.toList());
        List<String> operators = Arrays.stream(expression.split("[0-9]+")).collect(Collectors.toList());
        operators.remove(0);

        for (char operator : priority) {
            for (int j = 0; j < operators.size(); j++) {
                char now = operators.get(j).charAt(0);
                if (now == operator) {
                    long a = Long.parseLong(operands.get(j));
                    long b = Long.parseLong(operands.get(j + 1));
                    long result = operation(a, b, operator);
                    operands.remove(j);
                    operands.set(j, String.valueOf(result));
                    operators.remove(j--);
                }
            }
        }
        max = Math.max(max, Math.abs(Long.parseLong(operands.get(0))));
    }

    private static long operation(long a, long b, char operator) {
        switch (operator) {
            case '-':
                return a - b;
            case '+':
                return a + b;
            case '*':
                return a * b;
            default:
                return -1;
        }
    }
}