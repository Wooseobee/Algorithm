import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static String[] priorities = {"*+-", "*-+", "+-*", "+*-", "-+*", "-*+"};
    static long max = Long.MIN_VALUE;

    public long solution(String expression) {
        String operators = expression.replaceAll("[0-9]", "");

        for (String priority : priorities) {
            calculate(expression, priority);
        }
        return max;
    }

    private static void calculate(String expression, String priority) {
        List<String> operands = Arrays.stream(expression.split("[*+-]")).collect(Collectors.toList());
        List<String> operators = Arrays.stream(expression.split("[0-9]+")).collect(Collectors.toList());
        operators.remove(0);

        for (int i = 0; i < 3; i++) {
            char operator = priority.charAt(i);
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