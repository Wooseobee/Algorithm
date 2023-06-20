import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works) {
            pq.add(w);
        }
        for(int i = 0; i < n; i++) {
            int v = pq.poll();
            if(v == 0) break;
            pq.add(v-1);
        }
        while(!pq.isEmpty()){
            answer += (long) Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}