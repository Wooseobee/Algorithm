import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] levels;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        levels = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                levels[i][j] = Integer.parseInt(input[j]);
            }
        }

        check(0, 0);

        System.out.println(min);
        br.close();
    }

    static void check(int i, int size) {
        if (size == n / 2) {
            min = Math.min(min, checkPower());
            return;
        }
        for (int k = i; k < n; k++) {
            if (!visited[k]) {
                visited[k] = true;

                check(k,size + 1);

                visited[k] = false;
            }
        }
    }

    static int checkPower() {
        int score1 = 0, score2 = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i]&& visited[j]) {
                    score1 += levels[i][j];
                    score1 += levels[j][i];
                } else if (!visited[i] && !visited[j]) {
                    score2 += levels[i][j];
                    score2 += levels[j][i];
                }
            }
        }
        return Math.abs(score1 - score2);
    }
}