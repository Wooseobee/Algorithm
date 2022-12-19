import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);

        long[] bit = new long[55];

        bit[0] = 1;
        for (int i = 1; i < 55; i++) {
            bit[i] = 2 * bit[i - 1] + (1L << i);
        }

        long total = countOne(b, bit) - countOne(a - 1, bit);

        System.out.println(total);
        br.close();
    }

    static long countOne(long n, long[] bit) {
        long ans = n & 1;
        for (int i = 54; i > 0; i--) {
            if ((n & (1L << i)) > 0L) {
                ans += bit[i - 1] + (n - (1L << i) + 1);
                n -= (1L << i);
            }
        }
        return ans;
    }
}