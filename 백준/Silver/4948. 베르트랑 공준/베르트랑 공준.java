import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int cnt = countDecimal(n);

            if (cnt != 0) {
                bw.write(cnt + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int countDecimal(int n) {
        int cnt = 0;
        for (int i = n + 1; i <= 2 * n; i++) {
            if (i != 1 && isDecimal(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    static boolean isDecimal(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}