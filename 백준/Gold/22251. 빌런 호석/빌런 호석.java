import java.io.*;
import java.util.*;

public class Main {

    private static int n, k, p, x, total = 0;
    private static List<boolean[]> numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);    // 1~n층
        k = Integer.parseInt(in[1]);    // k 자리수
        p = Integer.parseInt(in[2]);    // p개 LED 반전
        x = Integer.parseInt(in[3]);    // 현재 x층

        numbers.add(new boolean[]{true, true, true, true, true, true, false});
        numbers.add(new boolean[]{false, true, true, false, false, false, false});
        numbers.add(new boolean[]{true, true, false, true, true, false, true});
        numbers.add(new boolean[]{true, true, true, true, false, false, true});
        numbers.add(new boolean[]{false, true, true, false, false, true, true});
        numbers.add(new boolean[]{true, false, true, true, false, true, true});
        numbers.add(new boolean[]{true, false, true, true, true, true, true});
        numbers.add(new boolean[]{true, true, true, false, false, false, false});
        numbers.add(new boolean[]{true, true, true, true, true, true, true});
        numbers.add(new boolean[]{true, true, true, true, false, true, true});

        int[] val = new int[k];
        int v = x;
        for (int i = 0; i < k; i++) {
            val[k - i - 1] = v % 10;
            v /= 10;
        }
        dfs(p, val, k - 1);
        System.out.println(total - 1);
        br.close();
    }

    private static void dfs(int last, int[] value, int idx) {
        if (last == 0 || idx < 0) {
            int newVal = 0;
            for (int i = k - 1, j = 1; i >= 0; i--, j *= 10) {
                newVal += value[i] * j;
            }
            if (newVal <= n && newVal != 0) {
                total++;
            }
            return;
        }
        int now = value[idx];
        for (int i = 0; i < 10; i++) {
            int need = checkLED(now, i);
            if (last >= need) {
                value[idx] = i;
                dfs(last - need, value, idx - 1);
                value[idx] = now;
            }
        }
    }

    private static int checkLED(int now, int target) {
        boolean[] nowArr = numbers.get(now);
        boolean[] targetArr = numbers.get(target);
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            if (nowArr[i] != targetArr[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
