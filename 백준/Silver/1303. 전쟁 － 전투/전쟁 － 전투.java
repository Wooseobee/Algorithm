import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, pow1 = 0, pow2 = 0, cnt = 0;
    static String[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new String[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = String.valueOf(s.charAt(j));
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                if (!visited[i][j] && board[i][j].equals("W")) {
                    cnt = calPow(i, j, "W");
                    pow1 += Math.pow(cnt, 2);
                }
            }
        }
        for (boolean[] bools : visited) {
            for (boolean bool : bools) {
                bool = false;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                if (!visited[i][j] && board[i][j].equals("B")) {
                    cnt = calPow(i, j, "B");
                    pow2 += Math.pow(cnt, 2);
                }
            }
        }
        br.close();
        System.out.println(pow1 + " " + pow2);
    }

    static int calPow(int x, int y, String s) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return 0;
        }

        visited[x][y] = true;
        cnt++;
        if (x + 1 < m && visited[x + 1][y] == false && s.equals(board[x + 1][y])) {
            calPow(x + 1, y, s);
        }
        if (x - 1 >= 0 && visited[x - 1][y] == false && s.equals(board[x - 1][y])) {
            calPow(x - 1, y, s);
        }
        if (y + 1 < n && visited[x][y + 1] == false && s.equals(board[x][y + 1])) {
            calPow(x, y + 1, s);
        }
        if (y - 1 >= 0 && visited[x][y - 1] == false && s.equals(board[x][y - 1])) {
            calPow(x, y - 1, s);
        }
        return cnt;
    }
}