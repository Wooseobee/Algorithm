import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        int d = Math.abs(s - Integer.parseInt(input[0]));
        for (int i = 1; i < n; i++) {
            d = gcd(d, Math.abs(s - Integer.parseInt(input[i])));
        }
        System.out.println(d);
        br.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}