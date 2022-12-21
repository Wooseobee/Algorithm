import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();

        while (true) {
            String s = br.readLine();

            if (s.equals(".")) {
                break;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)=='(' || s.charAt(i)=='[') {
                    stack.add(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        stack.add(s.charAt(i));
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (s.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        stack.add(s.charAt(i));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
            stack.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}