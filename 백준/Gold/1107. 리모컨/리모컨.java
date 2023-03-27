import java.io.*;
import java.util.*;

public class Main {
    static int min;
    static int[] btn;
    static List<Integer> brokenButton = new ArrayList<>();
    static String n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = br.readLine();
        int len = n.length();
        int m = Integer.parseInt(br.readLine());
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                brokenButton.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(brokenButton);
        int diffFromOneHundred = Math.abs(Integer.parseInt(n) - 100);
        min = brokenButton.contains(0) ? Integer.MAX_VALUE : Integer.parseInt(n) + 1;

        if (len > 1) {
            findUpperAndLowerCase(len - 1, false);
        }
        findUpperAndLowerCase(len + 1, true);

        btn = new int[len];
        search(0, 0, len);

        System.out.println(Math.min(min, diffFromOneHundred));
        br.close();
    }

    private static void findUpperAndLowerCase(int len, boolean upperCase) {
        int[] newBtn = new int[len];
        int depth = 0;
        int cnt = 0;
        while (depth < len) {
            cnt = upperCase ? upper(newBtn, depth, cnt) : lower(newBtn, depth, cnt);
            depth++;
        }
        if (cnt == len) {
            countButtonClick(len, newBtn);
        }
    }

    private static int upper(int[] newBtn, int depth, int cnt) {
        for (int i = 0; i < 10; i++) {
            if (brokenButton.contains(i) || (depth == 0 && i == 0)) {
                continue;
            }
            newBtn[depth] = i;
            return cnt + 1;
        }
        return cnt;
    }

    private static int lower(int[] newBtn, int depth, int cnt) {
        for (int i = 9; i >= 0; i--) {
            if (brokenButton.contains(i) || (depth == 0 && i == 0)) {
                continue;
            }
            newBtn[depth] = i;
            return cnt + 1;
        }
        return cnt;
    }

    private static void search(int depth, int idx, int len) {
        if (depth == len) {
            countButtonClick(len, btn);
            return;
        }
        for (int i = idx; i < 10; i++) {
            if (brokenButton.contains(i) || (depth == 0 && i == 0)) {
                continue;
            }
            btn[depth] = i;
            search(depth + 1, idx, len);
        }
    }

    private static void countButtonClick(int l, int[] btn) {
        String str = "";
        for (int i = 0; i < l; i++) {
            str += String.valueOf(btn[i]);
        }
        min = Math.min(min, l + Math.abs(Integer.parseInt(str) - Integer.parseInt(n)));
    }
}