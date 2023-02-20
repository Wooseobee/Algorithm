import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int l = 1;
        int r = k;
        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }
            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);

        br.close();
    }
}