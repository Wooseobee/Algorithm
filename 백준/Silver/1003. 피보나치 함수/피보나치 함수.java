import java.io.*;

public class Main {
    static int[] memoZero = new int[41];
    static int[] memoOne = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        memoZero[0] = 1;
        memoOne[0] = 0;
        memoZero[1] = 0;
        memoOne[1] = 1;

        for (int i = 2; i < 41; i++) {
            memoZero[i] = memoZero[i - 1] + memoZero[i - 2];
            memoOne[i] = memoOne[i - 1] + memoOne[i - 2];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            bw.write(memoZero[n] + " " + memoOne[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}