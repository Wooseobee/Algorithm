import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ipv6 = br.readLine();

        int colon = 0;
        for (int i = 0; i < ipv6.length(); i++) {
            if (ipv6.charAt(i) == ':') colon++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < ipv6.length(); i++) {
            char ch = ipv6.charAt(i);
            if (ch == ':') {
                if ((i == 0 && ipv6.charAt(i + 1) == ':') ||
                        (i == ipv6.length() - 2 && ipv6.charAt(i + 1) == ':')) {
                    for (int j = colon; j <= 8; j++) {
                        answer.append("0000:");
                    }
                } else if (i != ipv6.length() - 1 && ipv6.charAt(i + 1) == ':') {
                    for (int j = colon; j < 8; j++) {
                        answer.append("0000:");
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (ch != ':') {
                    i++;
                    sb.append(ch);
                    if (i == ipv6.length()) break;
                    ch = ipv6.charAt(i);
                }
                while (sb.length() < 4) {
                    sb.insert(0, "0");
                }
                answer.append(sb).append(":");
                i--;
            }
        }

        System.out.println(answer.delete(answer.length() - 1, answer.length()));
        br.close();
    }
}