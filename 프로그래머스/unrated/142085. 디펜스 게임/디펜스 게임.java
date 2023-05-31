import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            if (n >= enemy[i]) {
                n -= enemy[i];
            } else {
                if (k != 0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k--;
                    if (n >= enemy[i]) n -= enemy[i];
                    else if (k > 0) k--;
                    else return i;
                } else {
                    return i;
                }
            }
        }

        return enemy.length;
    }
}