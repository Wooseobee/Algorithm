import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BigInteger A = new BigInteger("1");
        BigInteger B = new BigInteger("1");

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A = A.multiply(new BigInteger(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B = B.multiply(new BigInteger(st.nextToken()));
        }

        BigInteger big = A.compareTo(B) > 0 ? A : B;
        BigInteger small = A.compareTo(B) > 0 ? B : A;
        BigInteger zero = new BigInteger("0");

        while (true) {
            BigInteger mod = big.mod(small);

            if (mod.compareTo(zero) == 0) break;

            big = small;
            small = mod;
        }
        sb.append(small.toString());

        if (sb.length() > 9) {
            bw.write(sb.substring(sb.length() - 9));
        } else {
            bw.write(String.valueOf(sb));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}