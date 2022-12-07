import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int total = 1;
        for (int i = n; i > n - k; i--) {
            total *= i;
        }

        for (int i = k; i >= 1; i--) {
            total /= i;
        }

        System.out.println(total);

        br.close();
    }
}