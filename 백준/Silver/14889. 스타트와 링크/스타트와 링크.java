import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[][] levels;
    static int[][] teams;
    static int[] visited;
    static int[] team1, team2;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        levels = new int[n][n];
        teams = new int[n][n];
        visited = new int[n];
        team1 = new int[n/2];
        team2 = new int[n/2];

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
            if (visited[k] == 0) {
                visited[k] = 1;
                team1[size] = k;

                check(k,size + 1);

                visited[k] = 0;
            }
        }
    }

    static int checkPower() {
        int score1 = 0, score2 = 0 , size = 0;
        for (int i : team1) {
            for (int j : team1) {
                if (i != j) {
                    teams[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j : team1) {
                if (i == j) {
                    cnt++;
                }
            }
            if (cnt==0) team2[size++] = i;
        }

        for (int i : team2) {
            for (int j : team2) {
                if (i != j) {
                    teams[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (teams[i][j] == 1) {
                    score1 += levels[i][j];
                } else if (teams[i][j] == -1) {
                    score2 += levels[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(teams[i], 0);
        }
        return Math.abs(score1 - score2);
    }
}