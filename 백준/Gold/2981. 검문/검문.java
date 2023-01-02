import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] m = new int[n];

        for (int i = 0; i < n; i++) {
            m[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(m);

        int gcd = m[1] - m[0];
        for (int i = 2; i < n; i++) {
            gcd = GCD(gcd, m[i] - m[i - 1]);
        }

        for (int i = 2; i <= gcd / 2; i++) {
            if (gcd % i == 0) bw.write(i + " ");
        }

        bw.write(gcd + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}