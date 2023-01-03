import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            binarySearch(n / 2);
        }

        br.close();
    }

    static void binarySearch(int mid) {
        int left = mid, right = mid;
        while (left > 1 && right < mid * 2) {
            if (isDecimal(left) && isDecimal(right)) {
                System.out.println(left + " " + right);
                return;
            } else {
                left--;
                right++;
            }
        }
    }

    static boolean isDecimal(int value) {
        if (value <= 1) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
}