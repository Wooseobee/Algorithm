import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(s[i]);
            if (value != 1 && checkDecimal(value)) {
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
    }

    static boolean checkDecimal(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}