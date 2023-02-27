import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[] paper;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split("");

            paper = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                paper[j] = Integer.parseInt(input[j]);
            }

            if (doFold(paper, 0, input.length)) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static boolean doFold(int[] paper, int start, int size) {
        if (size == 1) {
            return true;
        }
        if (!checkCanFold(paper, start, size)) {
            return false;
        }
        return doFold(paper, 0, size / 2) && doFold(paper, size / 2 + 1, size / 2);
    }

    private static boolean checkCanFold(int[] paper, int start, int size) {
        for (int i = start, j = start + size - 1; i < start + (size / 2); i++, j--) {
            if (paper[i] == paper[j]) return false;
        }
        return true;
    }
}