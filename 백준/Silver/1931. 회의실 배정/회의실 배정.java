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

        PriorityQueue<int[]> conference = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        int max = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            boolean addConference = false;
            int cnt = 0;
            while (!conference.isEmpty() && conference.peek()[0] <= now[0]) {
                cnt = Math.max(cnt, conference.poll()[1]);
                addConference = true;
            }
            if (addConference) {
                conference.add(new int[]{now[1], cnt + 1});
            }else {
                conference.add(new int[]{now[1], 1});
            }
            max = Math.max(max, cnt + 1);
        }

        System.out.println(max);
        br.close();
    }
}