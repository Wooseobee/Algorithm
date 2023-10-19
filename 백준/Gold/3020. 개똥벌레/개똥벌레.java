import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int h = Integer.parseInt(in[1]);
        int[] bottom = new int[h + 2];
        int[] top = new int[h + 2];
        for (int i = 1; i <= n / 2; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = h - Integer.parseInt(br.readLine()) + 1;
            bottom[a]++;
            top[b]++;
        }
        for (int i = 1; i <= h; i++) {
            bottom[i] += bottom[i - 1];
        }

        for (int i = h; i >= 1; i--) {
            top[i] += top[i + 1];
        }

        int min = n;
        int cnt = 0;
        for (int i = 1; i < h + 1; i++) {
            int dif = bottom[h] - bottom[i - 1];
            dif += top[1] - top[i + 1];

            if (dif < min) {
                min = dif;
                cnt = 1;
            } else if (dif == min) cnt++;
        }
        System.out.println(min + " " + cnt);
        br.close();
    }
}