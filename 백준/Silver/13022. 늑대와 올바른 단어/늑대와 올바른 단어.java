import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        System.out.println(checkWord(word));

        br.close();
    }

    private static int checkWord(String word) {
        int idx = 0;
        int wCnt = 0;
        int oCnt = 0;
        int lCnt = 0;
        int fCnt = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            switch (ch) {
                case 'w':
                    if (idx==0) wCnt++;
                    else if (idx == 3) {
                        if (wCnt == oCnt && oCnt == lCnt && lCnt == fCnt) {
                            idx = 0;
                            wCnt++;
                        }
                    } else {
                        return 0;
                    }
                    break;
                case 'o':
                    if (idx == 0) {
                        idx++;
                        oCnt++;
                    } else if (idx == 1) {
                        oCnt++;
                    } else {
                        return 0;
                    }
                    break;
                case 'l':
                    if (idx == 1) {
                        idx++;
                        lCnt++;
                    } else if (idx == 2) {
                        lCnt++;
                    } else {
                        return 0;
                    }
                    break;
                case 'f':
                    if (idx == 2) {
                        idx++;
                        fCnt++;
                    } else if (idx == 3) {
                        fCnt++;
                    } else {
                        return 0;
                    }
                    break;
            }
        }
        if (wCnt == oCnt && oCnt == lCnt && lCnt == fCnt) {
            return 1;
        }
        return 0;
    }
}