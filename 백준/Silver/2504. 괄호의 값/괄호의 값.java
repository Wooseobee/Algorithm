import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split("");
        br.close();
        Stack<String> stack = new Stack<>();

        int total = 0;
        int sum = 1;

        for (int i = 0; i < s.length; i++) {
            switch (s[i]) {
                case "(":
                    stack.push(s[i]);
                    sum *= 2;
                    break;
                case "[":
                    stack.push(s[i]);
                    sum *= 3;
                    break;
                case ")":
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        System.out.println(0);
                        return;
                    } else if (s[i - 1].equals("(")) {
                        total += sum;
                    }
                    stack.pop();
                    sum /= 2;
                    break;
                case "]":
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        System.out.println(0);
                        return;
                    } else if (s[i - 1].equals("[")) {
                        total += sum;
                    }
                    stack.pop();
                    sum /= 3;
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        } else {
            System.out.println(total);
        }
    }
}