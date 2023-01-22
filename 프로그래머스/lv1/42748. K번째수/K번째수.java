import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                pq.add(array[j]);
            }
            for (int j = 0; j < commands[i][2] - 1; j++) {
                pq.poll();
            }
            answer[i] = pq.poll();
        }

        return answer;
    }
}