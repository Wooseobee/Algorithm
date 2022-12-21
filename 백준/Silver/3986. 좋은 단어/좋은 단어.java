import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");

            for (int j = 0; j < s.length; j++) {
                if (stack.isEmpty()) {
                    stack.add(s[j]);
                } else {
                    if (!stack.peek().equals(s[j])) {
                        stack.add(s[j]);
                    } else {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) {
                cnt++;
            }
            stack.clear();
        }
        System.out.println(cnt);
    }
}