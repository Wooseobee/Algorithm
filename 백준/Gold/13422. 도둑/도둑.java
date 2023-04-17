import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] home = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                home[j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += home[j];
            }
            if (sum < k) cnt++;
            for (int j = 1; j < n; j++) {
                sum -= home[j - 1];
                sum += home[(j + m - 1) % n];
                if (sum < k) {
                    if (n != m) {
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}