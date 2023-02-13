import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());

        long start = 0;
        long sum = 0;
        while (sum <= s) {
            start++;
            sum += start;
        }

        System.out.println(start - 1);
        br.close();
    }
}