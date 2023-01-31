import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, cnt1 = 0, cnt2 = 0;
    static char[][] painting;
    static boolean[][] visited;
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        painting = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                painting[i][j] = input[j].charAt(0);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, painting[i][j]);
                    cnt1++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                painting[i][j] = painting[i][j] == 'B' ? 'B' : 'R';
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, painting[i][j]);
                    cnt2++;
                }
            }
        }
        sb.append(cnt1).append(" ").append(cnt2);
        System.out.println(sb);
        br.close();
    }

    static void dfs(int i, int j, char checkColor) {
        if (visited[i][j] || painting[i][j] != checkColor) return;

        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            if (i + moveY[k] >= 0 && j + moveX[k] >= 0 && i + moveY[k] < n && j + moveX[k] < n) {
                dfs(i + moveY[k], j + moveX[k], checkColor);
            }
        }
    }
}