import java.io.*;
import java.util.*;

public class Main {
    static int len, min = Integer.MAX_VALUE;
    static int[] btn;
    static List<Integer> brokenButton = new ArrayList<>();
    static String n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = br.readLine();
        len = n.length();
        btn = new int[len];
        int m = Integer.parseInt(br.readLine());
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                brokenButton.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(brokenButton);
        int diffFromOneHundred = Math.abs(Integer.parseInt(n) - 100);
        int diffFromZero = Integer.MAX_VALUE;
        if (!brokenButton.contains(0)) {
            diffFromZero = Integer.parseInt(n) + 1;
        }

        search(0, 0);

        findUpperCase();
        if (len>1) {
            findLowerCase();
        }

        System.out.println(Math.min(min, Math.min(diffFromOneHundred, diffFromZero)));
        br.close();
    }

    private static void findUpperCase() {
        int[] upBtn = new int[len + 1];
        int depth = 0;
        int cnt = 0;
        while (depth < len + 1) {
            for (int i = 0; i < 10; i++) {
                if (brokenButton.contains(i) || (depth == 0 && i == 0)) {
                    continue;
                }
                upBtn[depth] = i;
                cnt++;
                break;
            }
            depth++;
        }
        if (cnt==len+1) {
            countButtonClick(len + 1, upBtn);
        }
    }

    private static void findLowerCase() {
        int[] downBtn = new int[len - 1];
        int depth = 0;
        int cnt = 0;
        while (depth < len - 1) {
            for (int i = 9; i >= 0; i--) {
                if (brokenButton.contains(i) || (depth == 0 && i == 0)) {
                    continue;
                }
                downBtn[depth] = i;
                cnt++;
                break;
            }
            depth++;
        }
        if (cnt==len-1) {
            countButtonClick(len - 1, downBtn);
        }
    }

    private static void search(int depth, int idx) {
        if (depth == len) {
            countButtonClick(len, btn);
            return;
        }
        for (int i = idx; i < 10; i++) {
            if (brokenButton.contains(i) || (depth == 0 && i == 0)) {
                continue;
            }
            btn[depth] = i;
            search(depth + 1, idx);
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