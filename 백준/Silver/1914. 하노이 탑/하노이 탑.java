import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger big = new BigInteger("2");

        System.out.println(big.pow(n).subtract(new BigInteger("1")));
        
        if (n <= 20) {
            hanoi(n, 1, 2, 3);
            System.out.println(sb);
        }
    }

    static void hanoi(int n, int start, int via, int to) {
        if (n == 1) {
            sb.append(start + " " + to + "\n");
        } else {
            hanoi(n - 1, start, to, via);
            sb.append(start + " " + to + "\n");
            hanoi(n - 1, via, start, to);
        }
    }
}