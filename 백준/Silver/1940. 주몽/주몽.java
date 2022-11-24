import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] materials = new int[n];

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            materials[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int end = i + 1;

            while (end < n) {
                sum = materials[i];
                sum += materials[end++];
                if (sum == m) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

        br.close();
    }
}