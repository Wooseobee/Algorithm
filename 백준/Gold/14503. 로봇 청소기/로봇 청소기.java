import java.io.*;
import java.util.*;

/**
 * 0:북
 * 1:동
 * 2:남
 * 3:서
 */
public class Main {
    static int n, m, r, c, d, cnt = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaningRoom();
        System.out.println(cnt);
        br.close();
    }

    private static void cleaningRoom() {
        while (true) {
            if (room[r][c] == 0) {
                room[r][c] = 2;
                cnt++;
            }
            if (checkCleaningArea()) {
                d = (d + 3) % 4;
                if (room[r + dy[d]][c + dx[d]] == 0) {
                    r += dy[d];
                    c += dx[d];
                }
            } else {
                if (!canGoBack()) {
                    return;
                }
            }
        }
    }

    private static boolean canGoBack() {
        int back = (d + 2) % 4;
        int newI = r + dy[back];
        int newJ = c + dx[back];
        if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
            if (room[newI][newJ] != 1) {
                r += dy[back];
                c += dx[back];
                return true;
            }
        }
        return false;
    }

    private static boolean checkCleaningArea() {
        for (int i = 0; i < 4; i++) {
            int newI = r + dy[i];
            int newJ = c + dx[i];
            if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
                if (room[newI][newJ] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}