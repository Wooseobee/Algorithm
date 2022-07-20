import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 메모리 초과 해결을 위해 % 이용
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int flag = 0, i;
        int[] num;

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> deque = new LinkedList<>();

        for (i = 0; i < N; i++) {
            deque.add(new int[]{i + 1, Integer.parseInt(st.nextToken())});
        }

        while (N > 0) {
            if (flag == 0) {
                num = deque.poll();
            } else {
                num = deque.pollLast();
            }
            N--;
            if (N == 0) {
                sb.append(num[0] + " ");
                break;
            }
            if (num[1] > 0) {
                for (i = 0; i < (num[1] - 1) % N; i++) {
                    deque.addLast(deque.poll());
                }
                flag = 0;
            } else {
                if (N != 0) {
                    for (i = 0; i < Math.abs(num[1] + 1) % N; i++) {
                        deque.addFirst(deque.pollLast());
                    }
                    flag = 1;
                }
            }
            sb.append(num[0] + " ");
        }
        System.out.println(sb);
        br.close();
    }
}