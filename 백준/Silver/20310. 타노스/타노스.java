import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int zero = 0;
        int one = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                one++;
            }
        }

        zero /= 2;
        one /= 2;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (ch == '0') {
                if (zero > 0) {
                    zero--;
                    sb.append("0");
                }
            } else {
                if (one > 0) {
                    one--;
                } else {
                    sb.append("1");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
