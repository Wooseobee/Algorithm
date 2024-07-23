import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String start = br.readLine();
        int[] a = Arrays.stream(start.split("")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(start.split("")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int aCnt = 1;
        int bCnt = 0;
        a[0] = 1 - a[0];
        a[1] = 1 - a[1];
        for (int i = 1; i < n; i++) {
            if (a[i - 1] != end[i - 1]) {
                aCnt++;
                a[i - 1] = 1 - a[i - 1];
                a[i] = 1 - a[i];
                if (i != n - 1) {
                    a[i + 1] = 1 - a[i + 1];
                }
            }
            if (b[i - 1] != end[i - 1]) {
                bCnt++;
                b[i - 1] = 1 - b[i - 1];
                b[i] = 1 - b[i];
                if (i != n - 1) {
                    b[i + 1] = 1 - b[i + 1];
                }
            }
        }

        if (a[n - 1] != end[n - 1]) {
            aCnt = Integer.MAX_VALUE;
        }
        if (b[n - 1] != end[n - 1]) {
            bCnt = Integer.MAX_VALUE;
        }
        if (aCnt == Integer.MAX_VALUE && bCnt == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(aCnt, bCnt));
        }

        br.close();
    }
}
