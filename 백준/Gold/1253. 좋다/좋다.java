import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }

        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            if (isGood(now, i)) {
                ans++;
            }
        }

        System.out.println(ans);
        br.close();
    }

    private static boolean isGood(int now, int i) {
        int l = i == 0 ? 1 : 0, r = i == n - 1 ? n - 2 : n - 1;

        while (l < r) {
            int total = arr[l] + arr[r];

            if (total == now) {
                return true;
            } else if (total < now) {
                l++;
                if (l == i) {
                    l++;
                }
            } else {
                r--;
                if (r == i) {
                    r--;
                }
            }
        }
        return false;
    }
}