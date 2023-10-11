import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static final int MOD = 1_234_567_891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int r = Integer.parseInt(in[1]);

            long nn = factorial(n);
            long rr = factorial(r) * factorial(n - r) % MOD;

            long v = calc(rr) % MOD;
            long ans = (nn * v) % MOD;
            sb.append("#").append(i).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static long factorial(int v) {
        long fac = 1L;

        while (v > 1) {
            fac = (fac * v) % MOD;
            v--;
        }
        return fac;
    }

    private static long calc(long base) {
        long v = 1;
        long expo = MOD - 2;

        while(expo > 0) {
            if (expo % 2 == 1) {
                v = (v * base) % MOD;
            }
            base = (base * base) % MOD;
            expo /= 2;
        }
        return v;
    }
}