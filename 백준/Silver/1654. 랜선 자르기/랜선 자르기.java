import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int k = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int[] lan = new int[k];
        long left = 0, right = 0, mid;

        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, lan[i]);
        }

        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == 0) {
                mid = 1;
            }
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += (lan[i] / mid);
            }
            if (sum < n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);

        br.close();
    }
}