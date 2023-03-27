import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m;
    static long cnt = 0;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                aList.add(sum);
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                bList.add(sum);
            }
        }
        Collections.sort(aList);
        Collections.sort(bList);

        int l = 0;
        int r = bList.size() - 1;
        while (l < aList.size() && r >= 0) {
            int aSum = aList.get(l);
            int bSum = bList.get(r);
            long aCnt = 0;
            long bCnt = 0;
            if (aSum + bSum == t) {
                while (l < aList.size() && aList.get(l) == aSum) {
                    l++;
                    aCnt++;
                }
                while (r >= 0 && bList.get(r) == bSum) {
                    r--;
                    bCnt++;
                }
                cnt += aCnt * bCnt;
            } else if (aSum + bSum > t) {
                r--;
            } else if (aSum + bSum < t) {
                l++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}