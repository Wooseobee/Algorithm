import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int l = 0, r = 1;
        while (r < n) {
            int diff = arr[r] - arr[l];
            while (r < n && diff < m) {
                diff = arr[r++] - arr[l];
            }
            if (diff == m) {
                min = diff;
                break;
            }
            if (diff > m) {
                min = Math.min(min, diff);
            }
            l++;
            r = l + 1;
        }
        System.out.println(min);
        br.close();
    }
}