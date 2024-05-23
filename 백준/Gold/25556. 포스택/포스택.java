import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer>[] stacks = new Stack[4];

        for (int i = 0; i < 4; i++) {
            stacks[i] = new Stack<>();
        }

        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(in[i]);
            boolean canPush = false;

            for (int j = 0; j < 4; j++) {
                if (stacks[j].isEmpty() || stacks[j].peek() < now) {
                    stacks[j].push(now);
                    canPush = true;
                    break;
                }
            }

            if (!canPush) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
        br.close();
    }
}
