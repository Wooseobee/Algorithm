import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {

        bfs(numbers, target);

        return answer;
    }

    static class Sum {
        int sum;
        int idx;

        public Sum(int sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }

    public static void bfs(int[] numbers, int target) {
        Queue<Sum> q = new LinkedList<>();
        q.add(new Sum(numbers[0], 0));
        q.add(new Sum(-numbers[0], 0));

        while (!q.isEmpty()) {
            Sum s = q.poll();
            int sum = s.sum;
            int idx = s.idx;
            if (idx == numbers.length - 1 && target == sum) answer++;
            if (idx < numbers.length - 1) {
                q.add(new Sum(sum + numbers[idx + 1], idx + 1));
                q.add(new Sum(sum - numbers[idx + 1], idx + 1));
            }
        }
    }
}