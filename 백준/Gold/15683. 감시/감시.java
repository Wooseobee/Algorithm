import java.io.*;
import java.util.*;

public class Main {
    static class CCTV {
        int i;
        int j;
        char kind;

        public CCTV(int i, int j, char kind) {
            this.i = i;
            this.j = j;
            this.kind = kind;
        }
    }

    static int n, m, min = Integer.MAX_VALUE;
    static char[][] room;
    static List<CCTV> cctv = new ArrayList<>();
    static int cctvCnt = 0;
    static int[] ways;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        room = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine().replaceAll("\\s", "");
            room[i] = input.toCharArray();
            for (int j = 0; j < m; j++) {
                if (room[i][j] != '0' && room[i][j] != '6') {
                    cctv.add(new CCTV(i, j, room[i][j]));
                }
            }
        }
        cctvCnt = cctv.size();
        ways = new int[cctvCnt];

        search(0);
        System.out.println(min);
        br.close();
    }

    static void search(int depth) {
        if (depth == cctvCnt) {
            int[][] tmp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tmp[i][j] = room[i][j];
                }
            }
            min = Math.min(min, setCCTV(tmp));
            return;
        }
        for (int i = 0; i < 4; i++) {
            ways[depth] = i;
            search(depth + 1);
        }
    }

    static int setCCTV(int[][] tmp) {
        for (int i = 0; i < cctvCnt; i++) {
            CCTV now = cctv.get(i);
            int x = now.j;
            int y = now.i;
            char kind = now.kind;
            int way = ways[i];
            switch (kind) {
                case '5':
                    for (int k = 0; k < 4; k++) {
                        setCctvDirection(y, x, k, tmp);
                    }
                    break;
                case '4':
                    switch (way) {
                        case 0:
                            setCctvDirection(y, x, 0, tmp);
                            setCctvDirection(y, x, 2, tmp);
                            setCctvDirection(y, x, 3, tmp);
                            break;
                        case 1:
                            setCctvDirection(y, x, 1, tmp);
                            setCctvDirection(y, x, 2, tmp);
                            setCctvDirection(y, x, 3, tmp);
                            break;
                        case 2:
                            setCctvDirection(y, x, 0, tmp);
                            setCctvDirection(y, x, 1, tmp);
                            setCctvDirection(y, x, 2, tmp);
                            break;
                        case 3:
                            setCctvDirection(y, x, 0, tmp);
                            setCctvDirection(y, x, 1, tmp);
                            setCctvDirection(y, x, 3, tmp);
                            break;
                    }
                    break;
                case '3':
                    switch (way) {
                        case 0:
                            setCctvDirection(y, x, 0, tmp);
                            setCctvDirection(y, x, 2, tmp);
                            break;
                        case 1:
                            setCctvDirection(y, x, 1, tmp);
                            setCctvDirection(y, x, 3, tmp);
                            break;
                        case 2:
                            setCctvDirection(y, x, 1, tmp);
                            setCctvDirection(y, x, 2, tmp);
                            break;
                        case 3:
                            setCctvDirection(y, x, 0, tmp);
                            setCctvDirection(y, x, 3, tmp);
                            break;
                    }
                    break;
                case '2':
                    switch (way) {
                        case 0:
                        case 1:
                            setCctvDirection(y, x, 0, tmp);
                            setCctvDirection(y, x, 1, tmp);
                            break;
                        case 2:
                        case 3:
                            setCctvDirection(y, x, 2, tmp);
                            setCctvDirection(y, x, 3, tmp);
                            break;
                    }
                    break;
                case '1':
                    switch (way) {
                        case 0:
                            setCctvDirection(y, x, 0, tmp);
                            break;
                        case 1:
                            setCctvDirection(y, x, 1, tmp);
                            break;
                        case 2:
                            setCctvDirection(y, x, 2, tmp);
                            break;
                        case 3:
                            setCctvDirection(y, x, 3, tmp);
                            break;
                    }
                    break;
            }
        }
        return countRoom(tmp);
    }

    static void setCctvDirection(int i, int j, int direct, int[][] tmp) {
        switch (direct) {
            case 0: // 아래 방향
                for (int l = i + 1; l < n; l++) {
                    if (tmp[l][j] == '6') break;
                    else if (tmp[l][j] == '0') tmp[l][j] = '#';
                }
                break;
            case 1: // 위 방향
                for (int l = i - 1; l >= 0; l--) {
                    if (tmp[l][j] == '6') break;
                    else if (tmp[l][j] == '0') tmp[l][j] = '#';
                }
                break;
            case 2: // 왼쪽
                for (int l = j - 1; l >= 0; l--) {
                    if (tmp[i][l] == '6') break;
                    else if (tmp[i][l] == '0') tmp[i][l] = '#';
                }
                break;
            case 3: // 오른쪽:
                for (int l = j + 1; l < m; l++) {
                    if (tmp[i][l] == '6') break;
                    else if (tmp[i][l] == '0') tmp[i][l] = '#';
                }
                break;
        }
    }

    static int countRoom(int[][] tmp) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == '0') cnt++;
            }
        }
        return cnt;
    }
}