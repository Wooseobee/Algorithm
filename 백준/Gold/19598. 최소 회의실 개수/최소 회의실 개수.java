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

        int cnt = 0;
        List<Integer> conference = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            boolean addNewConference = false;
            for (int i = 0; i < conference.size(); i++) {
                int before = conference.get(i);
                if (before <= now[0]) {
                    addNewConference = true;
                    conference.remove(i);
                    conference.add(now[1]);
                    break;
                }
            }
            if (!addNewConference) {
                conference.add(now[1]);
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}