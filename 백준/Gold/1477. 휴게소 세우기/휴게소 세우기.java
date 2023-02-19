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
        int l = Integer.parseInt(input[2]);

        int[] rest = new int[n + 2];
        rest[n] = 0;
        rest[n + 1] = l;

        if (n != 0) {
            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                rest[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(rest);
        }

        int left = 0;
        int right = l;
        while (left < right) {
            int mid = (left + right) / 2;
            if (countRest(mid, n, rest) > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);

        br.close();
    }

    static int countRest(int dist, int n, int[] rest) {
        int cnt = 0;
        if (dist == 0) return rest[n + 1] - rest[0];
        for (int i = 1; i < n + 2; i++) {
            cnt += (rest[i] - rest[i - 1] - 1) / dist;
        }

        return cnt;
    }
}