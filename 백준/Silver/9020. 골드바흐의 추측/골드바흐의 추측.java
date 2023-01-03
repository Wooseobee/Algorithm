import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Search(n / 2);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void Search(int mid) throws IOException {
        int left = mid, right = mid;
        while (left > 1 && right < mid * 2) {
            if (isDecimal(left) && isDecimal(right)) {
                bw.write(left + " " + right + "\n");
                return;
            } else {
                left--;
                right++;
            }
        }
    }

    static boolean isDecimal(int value) {
        if (value <= 1) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
}