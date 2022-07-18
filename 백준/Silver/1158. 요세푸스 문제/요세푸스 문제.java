import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer N = Integer.parseInt(st.nextToken());
        Integer K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        sb.append("<");
        while (queue.size() > 1) {
            for (int i = 0; i < K-1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }
        sb.append(queue.poll());
        sb.append(">");

        br.close();
        System.out.println(sb);
    }
}