import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] trees = new int[n];
        int left = 0, right = 0, mid = 0;

        s = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(s[i]);
            right = Math.max(right, trees[i]);
        }

        while (left <= right) {
            mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    sum += (trees[i] - mid);
                }
            }
            if (sum >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}