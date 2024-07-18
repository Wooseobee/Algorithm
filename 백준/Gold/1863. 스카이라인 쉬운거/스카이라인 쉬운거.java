import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine().split(" ")[1]);
            if (stack.isEmpty() || i == n - 1) {
                if (h != 0) {
                    stack.push(h);
                }
            } else {
                int top = stack.peek();
                if (top >= h) {
                    while (!stack.isEmpty() && stack.peek() > h) {
                        cnt++;
                        stack.pop();
                    }
                    while (!stack.isEmpty() && stack.peek() == h) {
                        stack.pop();
                    }
                }
                if (h != 0) {
                    stack.push(h);
                }
            }
        }

        System.out.println(cnt + stack.size());
        br.close();
    }
}
