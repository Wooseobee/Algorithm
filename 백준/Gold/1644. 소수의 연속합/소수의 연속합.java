import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        boolean[] notPrime = new boolean[n + 1];

        setPrime(notPrime);
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) primeList.add(i);
        }

        System.out.println(countCase(primeList));

        br.close();
    }

    private static int countCase(List<Integer> primeList) {
        int cnt = 0;
        int s = 0, e = 0;
        int size = primeList.size();
        while (e <= size - 1) {
            int sum = 0;
            while (sum < n && e <= size - 1) {
                int prime = primeList.get(e++);
                sum += prime;
            }
            if (sum == n) {
                cnt++;
            }
            s++;
            e = s;
        }

        return cnt;
    }

    private static void setPrime(boolean[] notPrime) {
        for (int i = 2; i * i <= n; i++) {
            if (!notPrime[i]) { // 소수이면
                for (int j = i * i; j <= n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }
}