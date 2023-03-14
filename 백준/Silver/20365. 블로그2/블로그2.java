import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] problems = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            String now = problems[i];
            if (stack.isEmpty()) {
                if (now.equals("R")) {
                    stack.add(now);
                    cnt1++;
                }
            } else {
                if (now.equals("B")) {
                    stack.pop();
                }
            }
        }

        stack.clear();
        
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            String now = problems[i];
            if (stack.isEmpty()) {
                if (now.equals("B")) {
                    stack.add(now);
                    cnt2++;
                }
            } else {
                if (now.equals("R")) {
                    stack.pop();
                }
            }
        }

        System.out.println(Math.min(cnt1, cnt2) + 1);
        br.close();
    }
}