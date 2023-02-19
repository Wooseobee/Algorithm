import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] immigration = new int[n];

        for (int i = 0; i < n; i++) {
            immigration[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(immigration);

        System.out.println(solution(n, m, immigration));

        br.close();
    }

    static long solution(int n, int m, int[] immigration) {
        long low = 1;
        long high = (long) immigration[n - 1] * m;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canFinish(mid, n, m, immigration)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    static boolean canFinish(long mid, int n, int m, int[] immigration) {
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt += mid / immigration[i];
            if (cnt >= m) return true;
        }

        return m <= cnt;
    }
}