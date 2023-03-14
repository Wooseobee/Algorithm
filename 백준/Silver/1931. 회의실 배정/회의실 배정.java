import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            pq.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        int cnt = 0;
        int prev_end = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (prev_end <= now[0]) {
                cnt++;
                prev_end = now[1];
            }
        }

        System.out.println(cnt);
        br.close();
    }
}