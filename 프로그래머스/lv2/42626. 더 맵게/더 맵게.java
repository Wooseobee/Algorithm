import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (long food : scoville) {
            pq.add(food);
        }

        while (pq.size()>=2 && pq.peek() < K) {
            long first = pq.poll();
            long second = pq.poll();

            pq.add(first + (second * 2));
            answer++;
        }
        
        if (!pq.isEmpty() && pq.peek()<K) return -1;

        return answer;
    }
}