import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static int n, x, y, max;
    private static int[] order;
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String[] in = br.readLine().split(" ");
            n = Integer.parseInt(in[0]);
            x = Integer.parseInt(in[1]);
            y = Integer.parseInt(in[2]);

            map = new int[y][x];
            order = new int[n];
            max = 0;
            int total = 0;

            for (int j = 0; j < y; j++) {
                in = br.readLine().split(" ");
                for (int k = 0; k < x; k++) {
                    map[j][k] = Integer.parseInt(in[k]);
                    if (map[j][k] != 0) total++;
                }
            }

            findOrder(0);
            sb.append("#").append(i).append(" ").append(total - max).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void findOrder(int depth) {
        if (depth == n) {
            max = Math.max(max, checkMap());
            return;
        }
        for (int i = 0; i < x; i++) {
            order[depth] = i;
            findOrder(depth + 1);
        }
    }

    private static int checkMap() {
        int[][] copy = new int[y][x];
        for (int i = 0; i < y; i++) {
            copy[i] = Arrays.copyOf(map[i], x);
        }
        int breakCnt = 0;
        for (int k = 0; k < n; k++) {
            int i = 0;
            int j = order[k];
            boolean found = false;
            while (i < y) {
                if (copy[i][j] != 0) {
                    found = true;
                    break;
                }
                i++;
            }
            if (found) {
                breakCnt += breakBrick(i, j, copy);
                setMap(copy);
            }
        }
        return breakCnt;
    }

    private static void setMap(int[][] copy) {
        for (int j = 0; j < x; j++) {
            for (int i = y - 1; i > 0; i--) {
                if (copy[i][j] == 0) {
                    int next = i - 1;
                    while (next > 0 && copy[next][j] == 0) {
                        next--;
                    }
                    copy[i][j] = copy[next][j];
                    copy[next][j] = 0;
                }
            }
        }
    }

    private static int breakBrick(int sI, int sJ, int[][] copy) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        int power = copy[sI][sJ];
        q.add(new int[]{sI, sJ, power});
        copy[sI][sJ] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            int p = now[2];

            cnt++;
            if (p == 1) {
                continue;
            }
            while (p > 1) {
                for (int k = 0; k < 4; k++) {
                    int nI = i + dy[k] * (p - 1);
                    int nJ = j + dx[k] * (p - 1);
                    if (in(nI, nJ) && copy[nI][nJ] != 0) {
                        q.add(new int[]{nI, nJ, copy[nI][nJ]});
                        copy[nI][nJ] = 0;
                    }
                }
                p--;
            }
        }

        return cnt;
    }

    private static boolean in(int i, int j) {
        return i >= 0 && j >= 0 && i < y && j < x;
    }
}