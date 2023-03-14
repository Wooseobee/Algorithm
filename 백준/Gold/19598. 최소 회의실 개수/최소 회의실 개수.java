import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            pq.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        int max = 0;
        PriorityQueue<int[]> conference = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            while (!conference.isEmpty() && conference.peek()[1] <= now[0]) {
                conference.poll();
            }
            conference.add(now);
            max = Math.max(max, conference.size());
        }

        System.out.println(max);
        br.close();
    }
}