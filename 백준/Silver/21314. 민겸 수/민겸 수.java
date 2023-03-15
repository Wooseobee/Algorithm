import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("");

        StringBuilder min = new StringBuilder();
        StringBuilder max = new StringBuilder();
        int mCnt=0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("M")) {
                mCnt++;
            } else {
                if (mCnt == 0) {
                    min.append("5");
                    max.append("5");
                } else {
                    max.append("5");
                    for (int j = 1; j < mCnt; j++) {
                        max.append("0");
                    }
                    max.append("0");
                    min.append("1");
                    for (int j = 1; j < mCnt; j++) {
                        min.append("0");
                    }
                    min.append("5");
                }
                mCnt = 0;
            }
        }
        if (mCnt != 0) {
            for (int i = 0; i < mCnt; i++) {
                max.append("1");
            }
            min.append("1");
            for (int i = 1; i < mCnt; i++) {
                min.append("0");
            }
        }

        System.out.println(max + "\n" + min);
        br.close();
    }
}