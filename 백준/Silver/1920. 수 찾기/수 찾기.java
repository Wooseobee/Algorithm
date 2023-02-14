import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            if (isInArr(Integer.parseInt(input[i]), n, arr)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isInArr(int num, int len, int[] arr) {
        int left = 0;
        int right = len - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > num) {
                right = mid - 1;
                if (right < 0) {
                    return false;
                }
            } else if (arr[mid] == num) {
                return true;
            } else {
                left = mid + 1;
                if (left > len - 1) {
                    return false;
                }
            }
        }

        if (arr[right] == num) {
            return true;
        } else {
            return false;
        }
    }
}