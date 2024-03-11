import java.io.*;

public class Main {

    private static boolean[] used;
    private static String[] words;
    private static int n, k, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        used = new boolean[26];
        words = new String[n];

        // antic
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine().replaceAll("[antic]", "");
        }

        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }

        used[0] = true;
        used[2] = true;
        used[8] = true;
        used[13] = true;
        used[19] = true;

        backTracking(5, 0);

        System.out.println(max);

        br.close();
    }

    private static void backTracking(int cnt, int idx) {
        if (cnt == k) {
            countWord();
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!used[i]) {
                used[i] = true;
                backTracking(cnt + 1, i + 1);
                used[i] = false;
            }
        }
    }

    private static void countWord() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean canRead = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!used[words[i].charAt(j) - 'a']) {
                    canRead = false;
                    break;
                }  
            }
            if (canRead) cnt++;
        }
        max = Math.max(max, cnt);
    }
}