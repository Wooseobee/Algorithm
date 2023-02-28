import java.io.*;

public class Main {
    static boolean can = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        canChange(s, t);

        if (can) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        br.close();
    }

    static void canChange(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) can = true;
            return;
        } else if (s.length() < t.length() && t.length() > 1) {
            if (t.charAt(t.length() - 1) == 'A') canChange(s, removeA(t));
            if (t.charAt(0) == 'B') canChange(s, removeB(t));
        }
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