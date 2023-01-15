import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        Integer n = Integer.parseInt(br.readLine());
        int num = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (num < x) {
                for (int j = num + 1; j <= x; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                num = x;
                stack.pop();
                sb.append("-\n");
            } else if(stack.peek() == x){
                stack.pop();
                sb.append("-\n");
            }
            else {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb);

        br.close();
    }
}