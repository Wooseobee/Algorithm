import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] lecture = new int[n];
        int left = 0, right = 0;

        s = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            lecture[i] = Integer.parseInt(s[i]);
            left = Math.max(left, lecture[i]);
            right += lecture[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;   // 블루레이 크기
            int sum = 0;
            int cnt = 0;    // 블루레이 수
            for (int i = 0; i < n; i++) {
                if (sum + lecture[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += lecture[i];
            }
            if (sum != 0) {
                cnt++;
            }
            if (cnt > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);

        br.close();
    }
}