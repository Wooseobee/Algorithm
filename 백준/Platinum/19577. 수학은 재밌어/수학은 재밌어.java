import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        if (n != 1 && n % 2 == 1) {
            System.out.println(-1);
        } else {
            System.out.println(n <= 2 ? n : checkExist(n));
        }
        br.close();
    }

    private static long checkExist(long n) {
        List<Long> arr = new ArrayList<>();
        for (long i = 3; i * i <= n; i++) {
            if (n % i == 0) arr.add(i);
        }
        int len = arr.size();
        for (int i = 0; i < len; i++) {
            long v = arr.get(i);
            if (n / v != v) arr.add(n / v);
        }

        for (Long i : arr) {
            if (Euler(i) * i == n) return i;
        }
        return -1;
    }

    private static long Euler(long i) {
        long ans = i;
        for (long p = 2; p * p <= i; p++) {
            if (i % p == 0) ans = ans / p * (p - 1);
            while (i % p == 0) i /= p;
        }
        return i == 1 ? ans : ans / i * (i - 1);
    }
}