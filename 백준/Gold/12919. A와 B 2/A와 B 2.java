import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        canChange(s, t);

        if (canChange(s, t)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        br.close();
    }

    static boolean canChange(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) return true;
            return false;
        }
        if (t.charAt(t.length() - 1) == 'A') {
            if (canChange(s, removeA(t))) return true;
        }
        if (t.charAt(0) == 'B') {
            if (canChange(s, removeB(t))) {
                return true;
            }
        }
        return false;
    }

    static String removeA(String t) {
        StringBuilder sb = new StringBuilder(t);
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    static String removeB(String t) {
        StringBuilder sb = new StringBuilder(t);
        sb.reverse();
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}