import java.io.*;
import java.util.*;

public class Main {
    static int n, m, groupNum = 1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] group;
    static Map<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        group = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && group[i][j] == 0) {
                    hm.put(groupNum, setMapCanMove(i, j));
                    groupNum++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    sb.append(countCanMove(i, j));
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int setMapCanMove(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        group[i][j] = groupNum;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int k = 0; k < 4; k++) {
                int newI = now[0] + dy[k];
                int newJ = now[1] + dx[k];
                if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
                    if (map[newI][newJ] == 0 && group[newI][newJ] == 0) {
                        cnt++;
                        group[newI][newJ] = groupNum;
                        q.add(new int[]{newI, newJ});
                    }
                }
            }
        }
        return cnt;
    }

    private static int countCanMove(int i, int j) {
        int cnt = 1;
        Set<Integer> set = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int newI = i + dy[k];
            int newJ = j + dx[k];
            if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
                if (group[newI][newJ] == 0) {
                    continue;
                }
                if (map[newI][newJ] == 0) {
                    set.add(group[newI][newJ]);
                }
            }
        }
        for (int v : set) {
            cnt += hm.get(v);
        }
        return cnt % 10;
    }
}