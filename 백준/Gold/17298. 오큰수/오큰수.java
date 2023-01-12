import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] answer = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int now = Integer.parseInt(input[i]);
            while (!stack.isEmpty() && stack.peek() <= now) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }
            stack.add(now);
        }

        for (int i = 0; i < n; i++) {
            bw.write(answer[i] + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}