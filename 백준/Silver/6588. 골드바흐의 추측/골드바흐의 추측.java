import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;
            Goldbach(n / 2);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void Goldbach(int n) throws IOException {
        int left = 3, right = (n * 2) - 3;
        while (left <= n) {
            if (isDecimal(left) && isDecimal(right)) {
                bw.write(n * 2 + " = " + left + " + " + right + "\n");
                return;
            } else {
                left += 2;
                right -= 2;
            }
        }
        bw.write("Goldbach's conjecture is wrong.\n");
    }

    static boolean isDecimal(int value) {
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
}