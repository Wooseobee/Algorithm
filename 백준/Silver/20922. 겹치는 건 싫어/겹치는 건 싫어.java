import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] value = new int[100_001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            value[arr[i]]++;

            if (value[arr[i]] > k) {
                int v = arr[i];
                while (s <= e && arr[s] != v) {
                    value[arr[s++]]--;
                }
                value[arr[i]]--;
                s++;
            }
            e++;
            max = Math.max(max, e - s);
        }

        System.out.println(max);
        br.close();
    }
}