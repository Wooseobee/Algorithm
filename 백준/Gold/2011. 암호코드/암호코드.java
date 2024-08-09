import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();
        int ans = 0;
        int[][] arr = new int[27][n + 1];
        List<Integer>[] list = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);

            if (ch2 == '0') {
                int digit = Character.digit(ch1, 10);
                if (digit >= 3 || ch1 == '0') {
                    System.out.println(0);
                    return;
                }
            }
            if (ch1 == '0') {
                if (i == 0) {
                    System.out.println(0);
                    return;
                }
                list[i + 1].add(0);
                continue;
            }
            int val = Integer.parseInt(ch1 + Character.toString(ch2));

            list[i + 1].add(Character.digit(ch1, 10));
            if (val <= 26) {
                list[i + 1].add(val);
            }
        }
        list[n].add(Character.digit(s.charAt(n - 1), 10));

        for (int i = 1; i <= 2 && i <= n; i++) {
            for (int idx : list[i]) {
                if (idx != 0) {
                    arr[idx][i]++;
                }
            }
        }

        for (int i = 3; i <= n; i++) {
            for (int idx : list[i]) {
                if (idx != 0) {
                    for (int idx2 : list[i - 1]) {
                        if (idx2 != 0 && idx2 < 10) {
                            arr[idx][i] += (arr[idx2][i - 1]) % 1_000_000;
                        }
                    }
                }

                for (int idx2 : list[i - 2]) {
                    if (idx2 >= 10) {
                        arr[idx][i] += (arr[idx2][i - 2]) % 1_000_000;
                    }
                }
            }
        }

        ans += (arr[list[n].get(0)][n]);
        if (list[n - 1].size() > 1) {
            ans += (arr[list[n - 1].get(1)][n - 1]);
        }
        System.out.println(ans % 1_000_000);
        br.close();
    }
}
