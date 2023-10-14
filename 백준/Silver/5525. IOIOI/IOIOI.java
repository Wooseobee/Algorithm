import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0, len;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append("I");
        sb.append("OI".repeat(n));

        len = sb.length();
        StringBuilder window = new StringBuilder();
        for (int i = 0; i < len; i++) {
            window.append(s.charAt(i));
        }

        for (int i = 0; i < m - len; i++) {
            if (sb.toString().contentEquals(window)) ans++;
            window.deleteCharAt(0);
            window.append(s.charAt(i + len));
        }
        if (sb.toString().contentEquals(window)) ans++;

        System.out.println(ans);
        br.close();
    }
}