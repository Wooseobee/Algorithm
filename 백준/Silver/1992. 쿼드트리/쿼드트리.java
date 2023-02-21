import java.io.*;
import java.util.*;

public class Main {
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        video = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                video[i][j] = Integer.parseInt(input[j]);
            }
        }

        if (checkVideo(0, 0, n)) {
            if (video[0][0] == 0) System.out.println(0);
            else System.out.println(1);
        } else {
            solution(0, 0, n);
        }
        System.out.println(sb);
        br.close();
    }

    static void solution(int i, int j, int size) {
        if (checkVideo(i, j, size)) {
            if (video[i][j]==0) sb.append("0");
            else sb.append("1");
            return;
        }
        sb.append("(");
        solution(i, j, size / 2);
        solution(i, j + size / 2, size / 2);
        solution(i + size / 2, j, size / 2);
        solution(i + size / 2, j + size / 2, size / 2);
        sb.append(")");
    }

    static boolean checkVideo(int i, int j, int size) {
        int color = video[i][j];
        for (int k = i; k < i + size; k++) {
            for (int l = j; l < j + size; l++) {
                if (video[k][l]!=color) return false;
            }
        }
        return true;
    }
}