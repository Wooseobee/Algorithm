import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int max = 1_000_001;
    static boolean[] prime = new boolean[max + 1];

    public static void main(String[] args) throws IOException {

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    prime[j] = false;
                }
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;
            Goldbach(n);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void Goldbach(int n) throws IOException {
        int left = 3, right = n - 3;
        while (left <= right) {
            if (prime[left] && prime[right]) {
                bw.write(n + " = " + left + " + " + right + "\n");
                return;
            } else {
                left += 2;
                right -= 2;
            }
        }
        bw.write("Goldbach's conjecture is wrong.\n");
    }
}