import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map, laterMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        laterMap = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                laterMap[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'X') {
                    countAround(i, j);
                }
            }
        }

        printMap();
        br.close();
    }

    private static void printMap() {
        StringBuilder sb = new StringBuilder();
        int minR = 9;
        int maxR = 0;
        int minC = 9;
        int maxC = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (laterMap[i][j] == 'X') {
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i);
                    maxC = Math.max(maxC, j);
                }
            }
        }
        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                sb.append(laterMap[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void countAround(int i, int j) {
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            int newI = i + dy[k];
            int newJ = j + dx[k];
            if (newI >= 0 && newJ >= 0 && newI < r && newJ < c) {
                if (map[newI][newJ]=='X') cnt++;
            }
        }
        if (cnt < 2) {
            laterMap[i][j] = '.';
        }
    }
}