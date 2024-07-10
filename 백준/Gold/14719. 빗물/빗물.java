import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int total = 0;
        int[] max = new int[2];

        in = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(in[i]);
            if (max[0] < now) {
                max[0] = now;
                max[1] = i;
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < max[1]; i++) {
            int now = Integer.parseInt(in[i]);
            if (stack.isEmpty()) {
                stack.push(now);
            } else {
                int top = stack.peek();
                if (top > now) {
                    total += top - now;
                } else {
                    stack.pop();
                    stack.push(now);
                }
            }
        }

        stack.clear();

        for (int i = m - 1; i > max[1]; i--) {
            int now = Integer.parseInt(in[i]);
            if (stack.isEmpty()) {
                stack.push(now);
            } else {
                int top = stack.peek();
                if (top > now) {
                    total += top - now;
                } else {
                    stack.pop();
                    stack.push(now);
                }
            }
        }

        System.out.println(total);
        br.close();
    }
}
