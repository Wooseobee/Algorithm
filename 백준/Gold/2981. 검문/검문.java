import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] m = new int[n];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            m[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(m);

        int gcd = m[1] - m[0];
        for (int i = 2; i < n; i++) {
            gcd = gcd(gcd, m[i] - m[i - 1]);
        }

        for (int i = 2; i <= gcd; i++) {
            if (gcd % i == 0) System.out.print(i + " ");
        }
        br.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}