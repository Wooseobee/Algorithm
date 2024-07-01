import java.io.*;
import java.util.*;

public class Main {

    private static final char[] op = new char[]{'+', '-', ' '};
    private static List<String>[] ans;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        ans = new List[t];

        for (int i = 0; i < t; i++) {
            ans[i] = new ArrayList<>();
            findZero(i, new StringBuilder(), 1, Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < t; i++) {
            Collections.sort(ans[i]);
            for (String s : ans[i]) {
                sb.append(s).append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
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
        for (int j = 0; j < 3; j++) {
            findZero(t, str.append(op[j]), i + 1, n);
            str.delete(str.length() - 2, str.length());
        }
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
