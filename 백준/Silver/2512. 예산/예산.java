import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long left = 0, right = 0;

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(s[i]);
            right = Math.max(money[i], right);
        }
        long m = Integer.parseInt(br.readLine());

        while (left <= right) {
            long mid = (left + right) / 2;
            long budget = 0;
            for (int i = 0; i < n; i++) {
                if (money[i] > mid) {
                    budget += mid;
                } else {
                    budget += money[i];
                }
            }
            if (budget <= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
        br.readLine();
    }
}