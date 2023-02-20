import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            a[i] = Integer.parseInt(input[0]);
            b[i] = Integer.parseInt(input[1]);
            c[i] = Integer.parseInt(input[2]);
            d[i] = Integer.parseInt(input[3]);
        }

        int[] AB = new int[n * n];
        int[] CD = new int[n * n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx] = a[i] + b[j];
                CD[idx] = c[i] + d[j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int l = 0;
        int r = n * n - 1;
        long cnt = 0;

        while (l < n * n && r >= 0) {
            int lVal = AB[l];
            int rVal = CD[r];
            long lCnt = 0;
            long rCnt = 0;

            if (lVal + rVal == 0) {
                while (l < n * n && AB[l] == lVal) {
                    lCnt++;
                    l++;
                }
                while (r >= 0 && CD[r] == rVal) {
                    rCnt++;
                    r--;
                }
                cnt += lCnt * rCnt;
            } else if (lVal + rVal < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}