import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer>[] stacks = new Stack[4];
        Stack<Integer> ans = new Stack<>();

        boolean canClean = true;

        for (int i = 0; i < 4; i++) {
            stacks[i] = new Stack<>();
        }

        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(in[i]);
            int maxTop = -1;
            int maxIdx = -1;

            // 최대 top 값을 가진 스택을 찾기
            for (int j = 0; j < 4; j++) {
                if (stacks[j].isEmpty() || stacks[j].peek() < now) {
                    if (stacks[j].isEmpty() || stacks[j].peek() > maxTop) {
                        maxTop = stacks[j].isEmpty() ? Integer.MIN_VALUE : stacks[j].peek();
                        maxIdx = j;
                    }
                }
            }

            if (maxIdx != -1) {
                stacks[maxIdx].push(now);
            } else {
                // 4개의 스택 모두에 넣을 수 없는 경우
                canClean = false;
                break;
            }
        }

        if (canClean) {
            while (n > 0) {
                int maxTop = -1;
                int maxIdx = -1;

                // 최대 top 값을 가진 스택을 찾기
                for (int i = 0; i < 4; i++) {
                    if (!stacks[i].isEmpty() && stacks[i].peek() > maxTop) {
                        maxTop = stacks[i].peek();
                        maxIdx = i;
                    }
                }

                if (maxIdx != -1) {
                    int pop = stacks[maxIdx].pop();
                    if (ans.isEmpty() || ans.peek() >= pop) {
                        ans.push(pop);
                    } else {
                        canClean = false;
                        break;
                    }
                } else {
                    canClean = false;
                    break;
                }
                n--;
            }
        }

        System.out.println(canClean ? "YES" : "NO");
        br.close();
    }
}
