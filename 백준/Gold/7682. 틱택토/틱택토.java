import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String in = br.readLine();
            if (in.equals("end")) {
                break;
            }
            checkValid(in);
        }

        System.out.println(sb);
        br.close();
    }

    private static void checkValid(String in) {
        char[][] map = new char[3][3];
        int xCnt = 0;
        int oCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = in.charAt(i * 3 + j);
                if (map[i][j] == 'X') {
                    xCnt++;
                } else if (map[i][j] == 'O') {
                    oCnt++;
                }
            }
        }

        if (xCnt + oCnt == 9 && xCnt == oCnt + 1) {
            if (check(map, 'X') && check(map, 'O')) {
                sb.append("invalid").append("\n");
            } else if (check(map, 'O')) {
                sb.append("invalid").append("\n");
            } else {
                sb.append("valid").append("\n");
            }
        } else {
            if (check(map, 'X') && check(map, 'O')) {
                sb.append("invalid").append("\n");
            } else if (check(map, 'X') && xCnt == oCnt + 1) {
                sb.append("valid").append("\n");
            } else if (check(map, 'O') && xCnt == oCnt) {
                sb.append("valid").append("\n");
            } else {
                sb.append("invalid").append("\n");
            }
        }
    }

    private static boolean check(char[][] map, char ch) {
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == ch) cnt++;
            }
            if (cnt == 3) return true;
        }
        for (int j = 0; j < 3; j++) {
            int cnt = 0;
            for (int i = 0; i < 3; i++) {
                if (map[i][j] == ch) cnt++;
            }
            if (cnt == 3) return true;
        }
        if (map[0][0] == ch && map[1][1] == ch
                && map[2][2] == ch) return true;
        if (map[0][2] == ch && map[1][1] == ch
                && map[2][0] == ch) return true;

        return false;
    }
}
