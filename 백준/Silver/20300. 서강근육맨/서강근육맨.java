import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] health = new long[n];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            health[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(health);

        long min;
        int idx = 0;
        if (n % 2 == 0) {
            min = 0;
            while (idx < n / 2) {
                min = Math.max(min, health[idx] + health[n - idx - 1]);
                idx++;
            }
        } else {
            min = health[n - 1];
            while (idx < n / 2) {
                min = Math.max(min, health[idx] + health[n - idx - 2]);
                idx++;
            }
        }

        System.out.println(min);
        br.close();
    }
}