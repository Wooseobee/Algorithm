import java.io.*;

public class Main {
    static int lcs;
    static boolean found = false;
    static char[] str1;
    static char[] str2;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        str1 = new char[s1.length() + 1];
        str2 = new char[s2.length() + 1];
        dp = new int[str1.length][str2.length];

        for (int i = 0; i < s1.length(); i++) {
            str1[i + 1] = s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            str2[i + 1] = s2.charAt(i);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        lcs = dp[s1.length()][s2.length()];
        System.out.println(lcs);
        if (lcs != 0) {
            System.out.println(searchLCS(s1.length(), s2.length(), new StringBuilder()));
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

    // 시간 초과
//    private static void searchLCS(int i, int j, String answer) {
//        if (i < 1 || j < 1 || found) {
//            if (!found && answer.length() == lcs) {
//                found = true;
//                sb.append(answer);
//            }
//            return;
//        }
//
//        if (str1[i] == str2[j]) {
//            searchLCS(i - 1, j - 1, answer + str1[i]);
//        } else {
//            searchLCS(i - 1, j, answer);
//            searchLCS(i, j - 1, answer);
//        }
//    }
}