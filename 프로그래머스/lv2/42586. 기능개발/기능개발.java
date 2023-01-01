import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> functions = new ArrayList<>();

        int len = progresses.length;

        for (int i = 0; i < len; i++) {
            q.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        while (!q.isEmpty()) {
            int first = q.poll();
            int cnt = 1;
            while (!q.isEmpty() && first >= q.peek()) {
                int next = q.poll();
                cnt++;
            }
            functions.add(cnt);
        }

        return functions.stream().mapToInt(i -> i).toArray();
    }
}