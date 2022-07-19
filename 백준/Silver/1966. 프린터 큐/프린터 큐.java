import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer t = Integer.parseInt(br.readLine());

        LinkedList<int[]> queue = new LinkedList<>();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                queue.offer(new int[] { j, Integer.parseInt(st.nextToken())});
            }

            while (!queue.isEmpty()) {
                int flag = 0;
                int[] first = queue.poll();
                for (int j = 0; j < queue.size(); j++) {
                    if (first[1] < queue.get(j)[1]) {
                        queue.offer(first);
                        for (int k = 0; k < j; k++) {
                            queue.offer(queue.poll());
                        }
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    cnt++;
                    if (first[0] == M) {
                        break;
                    }
                }
            }
            System.out.println(cnt);
            queue.clear();
        }
        br.close();
    }
}