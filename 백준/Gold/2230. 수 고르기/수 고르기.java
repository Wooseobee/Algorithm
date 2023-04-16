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
            if (arr[r] - arr[l] < m) {
                r++;
                continue;
            }
            if (arr[r] - arr[l] == m) {
                min = m;
                break;
            }
            min = Math.min(min, arr[r] - arr[l]);
            l++;
        }
        System.out.println(min);
        br.close();
    }
}