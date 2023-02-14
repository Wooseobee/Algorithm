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

        input = br.readLine().split(" ");
        int[] point = new int[n];
        for (int i = 0; i < n; i++) {
            point[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(point);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int left = 0;
            int right = n - 1;
            int mid;
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            while (left <= right) {
                mid = (left + right) / 2;
                if (point[mid] >= start) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            start = left;

            left = 0;
            right = n - 1;

            while (left <= right) {
                mid = (left + right) / 2;
                if (point[mid] > end) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int startIdx = start;
            int endIdx = right;

            sb.append(endIdx - startIdx + 1).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}