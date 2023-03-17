import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("");

        int cntZero = 0;
        int cntOne = 0;
        if (s[0].equals("0")) {
            cntZero++;
        } else {
            cntOne++;
        }
        for (int i = 1; i < s.length; i++) {
            if (!s[i].equals(s[i - 1])) {
                if (s[i].equals("0")) {
                    cntZero++;
                } else {
                    cntOne++;
                }
            }
        }

        System.out.println(Math.min(cntZero, cntOne));
        br.close();
    }
}