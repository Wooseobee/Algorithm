import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        int num = 1;

        for (int i = 0; i < priorities.length; i++) {
            q.add(priorities[i]);
        }

        while (!q.isEmpty()) {
            int J = q.poll();
            boolean canPrint = true;

            for (int i = J + 1; i <= 9; i++) {
                if (q.contains(i)) {
                    canPrint = false;
                    break;
                }
            }
            if (location == 0) {
                if (canPrint) {
                    answer = num;
                    break;
                } else {
                    q.add(J);
                    location = q.size() - 1;
                }
            } else {
                if (canPrint) {
                    num++;
                } else {
                    q.add(J);
                }
                location--;
            }
        }

        return answer;
    }
}