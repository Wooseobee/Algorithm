import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        if (n != 1) factorization(n);

        bw.flush();
        bw.close();
        br.close();
    }

    static void factorization(int n) throws IOException {
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                bw.write(i + "\n");
                n /= i;
            }
        }
    }
}