import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        boolean have = false;
        int n = Integer.parseInt(s);

        for (int i = 1; i < n ; i ++) {
            int sum = i;
            int checkNum = i;
            while (checkNum > 0) {
                sum += (checkNum % 10);
                checkNum /= 10;
            }
            if (sum == n) {
                System.out.println(i);
                have = true;
                break;
            }
        }
        if (!have) {
            System.out.println(0);
        }
    }
}