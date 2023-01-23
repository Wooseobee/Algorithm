import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        int len = jobs.length;
        int cnt = 0;
        int idx = 0;
        int end = 0;

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        while (cnt < len) {
            while (idx < len && jobs[idx][0] <= end) {
                pq.add(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                end = jobs[idx][0];
            } else {
                int[] tmp = pq.poll();
                answer += tmp[1] + end - tmp[0];
                end += tmp[1];
                cnt++;
            }
        }

        return (int) Math.floor(answer / len);
    }
}