import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        BigInteger answer = new BigInteger("1");

        if (n - m > n / 2) {
            for (int i = n; i > n - m; i--) {
                answer = answer.multiply(new BigInteger(String.valueOf(i)));
            }
            for (int i = 1; i <= m; i++) {
                answer = answer.divide(new BigInteger(String.valueOf(i)));
            }
        } else {
            for (int i = n; i > m; i--) {
                answer = answer.multiply(new BigInteger(String.valueOf(i)));
            }
            for (int i = 1; i <= n - m; i++) {
                answer = answer.divide(new BigInteger(String.valueOf(i)));
            }
        }
        System.out.println(answer);
        br.close();
    }
}