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

        for (int i = input.length - 1; i >= 0; i--) {
            int now = Integer.parseInt(input[i]);
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (top > now) {
                    answer[i] = top;
                    stack.add(now);
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                stack.add(now);
                answer[i] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(answer[i] + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}