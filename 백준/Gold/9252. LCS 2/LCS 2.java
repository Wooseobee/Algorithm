import java.io.*;

public class Main {
    static int lcs;
    static char[] str1;
    static char[] str2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int len1 = s1.length();
        int len2 = s2.length();

        str1 = new char[len1 + 1];
        str2 = new char[len2 + 1];
        dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            str1[i + 1] = s1.charAt(i);
        }
        for (int i = 0; i < len2; i++) {
            str2[i + 1] = s2.charAt(i);
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        lcs = dp[len1][len2];
        System.out.println(lcs);
        if (lcs != 0) {
            System.out.println(searchLCS(len1, len2, new StringBuilder()));
        }

        br.close();
    }

    private static StringBuilder searchLCS(int i, int j, StringBuilder answer) {
        while (i >= 1 && j >= 1) {
            if (str1[i] == str2[j]) {
                answer.append(str1[i]);
                i--;
                j--;
            } else {
                if (dp[i][j] == dp[i - 1][j]) {
                    i--;
                } else if (dp[i][j] == dp[i][j - 1]) {
                    j--;
                }
            }
        }
        return answer.reverse();
    }
}