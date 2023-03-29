import java.io.*;
import java.util.*;

public class Main {
    static class FireBall {
        int r;
        int c;
        int w;
        int d;
        int s;

        public FireBall(int r, int c, int w, int d, int s) {
            this.r = r;
            this.c = c;
            this.w = w;
            this.d = d;
            this.s = s;
        }
    }

    static int n, m, k;
    static List<FireBall> fireBalls = new ArrayList<>();
    static Map<Integer, int[]> ways = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        setWays();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireBalls.add(new FireBall(r, c, w, d, s));
        }

        for (int i = 0; i < k; i++) {
            moveFireBall();
        }

        System.out.println(countRemainFireBall());
        br.close();
    }

    private static int countRemainFireBall() {
        int total = 0;
        for (FireBall fireBall : fireBalls) {
            total += fireBall.w;
        }
        return total;
    }

    private static void setWays() {
        ways.put(0, new int[]{-1, 0});
        ways.put(1, new int[]{-1, 1});
        ways.put(2, new int[]{0, 1});
        ways.put(3, new int[]{1, 1});
        ways.put(4, new int[]{1, 0});
        ways.put(5, new int[]{1, -1});
        ways.put(6, new int[]{0, -1});
        ways.put(7, new int[]{-1, -1});
    }

    private static void moveFireBall() {
        int idx = 0;
        int[][] fireBallIndex = new int[n + 1][n + 1];  // 파이어볼 배열
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(fireBallIndex[i], -1);
        }
        List<List<Integer>> fireBallIndexList = new ArrayList<>();
        boolean separate = false;
        for (int i = 0; i < fireBalls.size(); i++) {
            fireBallIndexList.add(new ArrayList<>());
        }

        for (FireBall fireBall : fireBalls) {
            int r = fireBall.r;
            int c = fireBall.c;
            int w = fireBall.w;
            int d = fireBall.d;
            int s = fireBall.s;
            int newS = s % n;

            for (int i = 0; i < newS; i++) {
                int[] newPosition = setDirection(r, c, d);
                r = newPosition[0];
                c = newPosition[1];
            }

            fireBalls.set(idx, new FireBall(r, c, w, d, s));
            if (fireBallIndex[r][c] == -1) {
                fireBallIndex[r][c] = idx;
            } else {
                separate = true;
            }
            fireBallIndexList.get(fireBallIndex[r][c]).add(idx++);
        }

        if (separate) {
            mergeFireBalls(fireBallIndexList);
        }
    }

    private static int[] setDirection(int r, int c, int d) {
        int[] way = ways.get(d);
        r += way[0];
        c += way[1];
        if (r == 0) {   // 파이어볼이 맵 위로 넘어간 경우
            r = n;
            if (c == 0) {
                c = n;
            } else if (c == n + 1) {
                c = 1;
            }
        } else if (r == n + 1) {    // 파이어볼이 맵 아래로 넘어간 경우
            r = 1;
            if (c == 0) {
                c = n;
            } else if (c == n + 1) {
                c = 1;
            }
        } else if (c == 0) {    // 파이어볼이 맵 왼쪽으로 넘어간 경우
            c = n;
        } else if (c == n + 1) {
            c = 1;
        }
        return new int[]{r, c};
    }

    private static void mergeFireBalls(List<List<Integer>> fireBallIndexList) {
        List<Integer> removeList = new ArrayList<>();
        for (List<Integer> fireBallIndex : fireBallIndexList) {
            if (fireBallIndex.size() <= 1) continue;
            int totalWeight = 0;
            int totalSpeed = 0;
            int totalFireBall = 0;
            int directionCnt = 0;
            FireBall f = null;
            for (int fireBall : fireBallIndex) {
                f = fireBalls.get(fireBall);
                totalSpeed += f.s;
                totalWeight += f.w;
                totalFireBall++;
                if (f.d % 2 == 1) {
                    directionCnt++;
                }
                removeList.add(fireBall);
            }

            int w = totalWeight / 5;
            int s = totalSpeed / totalFireBall;

            if (w == 0) continue;
            if (directionCnt == totalFireBall || directionCnt == 0) {
                for (int i = 0; i <= 6; i += 2) {
                    fireBalls.add(new FireBall(f.r, f.c, w, i, s));
                }
            } else {
                for (int i = 1; i <= 7; i += 2) {
                    fireBalls.add(new FireBall(f.r, f.c, w, i, s));
                }
            }
        }
        Collections.sort(removeList);
        removeFireBall(removeList);
    }

    private static void removeFireBall(List<Integer> removeList) {
        for (int i = 0; i < removeList.size(); i++) {
            fireBalls.remove(removeList.get(i) - i);
        }
    }
}