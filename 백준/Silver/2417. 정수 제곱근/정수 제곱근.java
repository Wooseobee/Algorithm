import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        if ((long) Math.sqrt(n) * (long) Math.sqrt(n) >= n) {
            System.out.println((long) Math.sqrt(n));
        }else {
            System.out.println((long) Math.sqrt(n) + 1);
        }
        br.close();
    }
}