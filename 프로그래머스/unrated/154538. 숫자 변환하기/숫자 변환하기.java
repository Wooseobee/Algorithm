import java.util.*;

class Solution {
    static class Num {
        int num;
        int cnt;

        public Num(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }

    private static int bfs(int x, int y, int n) {
        Queue<Num> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(new Num(x, 0));
        set.add(x);

        while (!q.isEmpty()) {
            Num num = q.poll();
            int now = num.num;
            int cnt = num.cnt;

            if (now > y) continue;
            if (now == y) return cnt;

            if (!set.contains(now + n)) {
                q.add(new Num(now + n, cnt + 1));
                set.add(now + n);
            }
            if (!set.contains(now * 2)) {
                q.add(new Num(now * 2, cnt + 1));
                set.add(now * 2);
            }
            if (!set.contains(now * 3)) {
                q.add(new Num(now * 3, cnt + 1));
                set.add(now * 3);
            }
        }
        return -1;
    }
}