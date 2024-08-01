import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int aCnt = 0;
        int len = str.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'a') {
                aCnt++;
            }
        }

        for (int i = 0; i < len; i++) {
            int bCnt = 0;
            for (int j = 0; j < aCnt; j++) {
                int idx = (i + j) % len;
                if (str.charAt(idx) == 'b') {
                    bCnt++;
                }
            }
            min = Math.min(min, bCnt);
        }

        System.out.println(min);
        br.close();
    }
}
