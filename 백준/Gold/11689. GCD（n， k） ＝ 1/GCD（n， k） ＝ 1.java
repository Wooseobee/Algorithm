import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long ans = n;
        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) ans = ans / p * (p - 1);
            while (n % p == 0) n /= p;
        }

        System.out.println(n == 1 ? ans : ans / n * (n - 1));
        br.close();
    }
}