import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//시간 초과
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int last = Integer.parseInt(st.nextToken());
        stack.push(new int[] {0, last});
        System.out.print("0 ");
        for (int i = 1; i < N ; i++) {
            last = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {
                if (last <= stack.peek()[1]) {
                    System.out.print(stack.peek()[0]+1 + " ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.print("0 ");
            }
            stack.push(new int[]{i, last});
        }
    }
}