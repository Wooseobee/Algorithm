import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int total = 0;
            int idx = i;
            while (idx < n && total < m) {
                total += arr[idx++];
            }
            if (total == m) {
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}