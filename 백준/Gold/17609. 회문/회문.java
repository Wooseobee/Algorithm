import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split("");

            int cnt = checkPalindrome(0, input.length - 1, input, false);
            if (cnt == 0) {
                sb.append("0").append("\n");
            } else if (cnt == 1) {
                sb.append("1").append("\n");
            } else {
                sb.append("2").append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static int checkPalindrome(int s, int e, String[] input, boolean checked) {
        if (s >= e) {
            return 0;
        }
        if (input[s].charAt(0) != input[e].charAt(0)) {
            if (checked) return 1;
            int left = checkPalindrome(s + 1, e, input, true);
            int right = checkPalindrome(s, e - 1, input, true);
            return Math.min(left, right) + 1;
        }
        return checkPalindrome(s + 1, e - 1, input, false);
    }
}