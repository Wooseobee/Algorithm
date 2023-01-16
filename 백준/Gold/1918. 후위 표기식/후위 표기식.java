import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();

        String s[] = br.readLine().split("");
        br.close();

        for (int i = 0; i < s.length; i++) {
            switch (s[i]) {
                case "(":
                    stack.push(s[i]);
                    break;
                case ")":
                    while (!stack.isEmpty()&&!stack.peek().equals("(")) {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                case"+":
                case"-":
                    while (!stack.isEmpty()&&!stack.peek().equals("(")) {
                        sb.append(stack.pop());
                    }
                    stack.push(s[i]);
                    break;
                case"*":
                case"/":
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        sb.append(stack.pop());
                    }
                    stack.push(s[i]);
                    break;
                default:
                    sb.append(s[i]);
                    break;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}