import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n + 1];
        int[] cnt = new int[n + 1];
        int[] near = new int[n + 1];
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        String[] in = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(in[i - 1]);
            near[i] = -100_001;
        }

        for (int i = 1; i <= n; i++) {
            while (!left.isEmpty() && h[left.peek()] <= h[i]) {
                left.pop();
            }
            cnt[i] = left.size();
            if (cnt[i] > 0) {
                near[i] = left.peek();
            }
            left.push(i);
        }
        for (int i = n; i > 0; i--) {
            while (!right.isEmpty() && h[right.peek()] <= h[i]) {
                right.pop();
            }
            cnt[i] += right.size();
            if (!right.isEmpty() && right.peek() - i < i - near[i]) {
                near[i] = right.peek();
            }
            right.push(i);
        }

        for (int i = 1; i <= n; i++) {
            sb.append(cnt[i]);
            if (cnt[i] > 0) {
                sb.append(" ").append(near[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
