import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Stack<int[]> stack = new Stack<>();

        stack.add(new int[]{0, arr[0]});
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < arr[i]) {
                answer[stack.pop()[0]] = arr[i];
            }
            stack.add(new int[]{i, arr[i]});
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()[0]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}