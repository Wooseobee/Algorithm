import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char answer;
        int len = 3;
        int i = 0;
        while (len < n) {
            i++;
            len = (len * 2) + (i + 3);
        }

        while (true) {
            int midIdx = (len - i - 3) / 2;
            if (n <= midIdx) {
                i--;
                len = midIdx;
            } else if (n > midIdx + i + 3) {
                n -= midIdx + i + 3;
                i--;
                len = midIdx;
            } else {
                if (n == midIdx + 1) answer = 'm';
                else answer = 'o';
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }
}