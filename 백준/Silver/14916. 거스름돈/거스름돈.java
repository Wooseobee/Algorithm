import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        if (n % 5 == 0) {
            cnt = n / 5;
            n = 0;
        } else {
            while (n >= 2) {
                n-=2;
                cnt++;
                if (n != 0 && n % 5 == 0) {
                    cnt += n / 5;
                    n = 0;
                    break;
                }
            }
        }
        if (n != 0) {
            System.out.println("-1");
        } else {
            System.out.println(cnt);
        }
    }
}