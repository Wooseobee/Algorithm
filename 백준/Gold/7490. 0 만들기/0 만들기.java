import java.io.*;
import java.util.*;

public class Main {

    private static List<String> ans[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        ans = new List[t];
        int[] tc = new int[t];
        for (int i = 0; i < t; i++) {
            tc[i] = Integer.parseInt(br.readLine());
            ans[i] = new ArrayList<>();
        }

        for (int i = 0; i < t; i++) {
            findZero(i, new StringBuilder(), 1, tc[i]);
        }

        for (int i = 0; i < t; i++) {
            Collections.sort(ans[i]);
            for (String s : ans[i]) {
                System.out.println(s);
            }
            System.out.println();
        }
        br.close();
    }

    private static void findZero(int t, StringBuilder str, int i, int n) {
        if (i == n) {
            str.append(i);
            if (isZero(str)) {
                ans[t].add(str.toString());
            }
            return;
        }
        str.append(i);
        findZero(t, str.append("+"), i + 1, n);
        str.delete(str.length() - 2, str.length());
        findZero(t, str.append("-"), i + 1, n);
        str.delete(str.length() - 2, str.length());
        findZero(t, str.append(" "), i + 1, n);
        str.delete(str.length() - 2, str.length());
    }

    private static boolean isZero(StringBuilder str) {
        String noSpace = str.toString().replaceAll(" ", "");
        String[] digit = noSpace.split("[+-]");
        String[] op = noSpace.split("[0-9]");
        int total = Integer.parseInt(digit[0]), idx = 1;

        for (int i = 0; i < op.length; i++) {
            if (!op[i].equals("")) {
                if (op[i].equals("+")) {
                    total += Integer.parseInt(digit[idx++]);
                } else {
                    total -= Integer.parseInt(digit[idx++]);
                }
            }
        }

        return total == 0;
    }
}