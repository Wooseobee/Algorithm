import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        long n = Long.parseLong(input[0]);
        long k = Long.parseLong(input[1]);

        long l = 0;
        long r = n / 2;
        boolean canCut = false;
        while (l <= r) {
            long row = (l + r) / 2;
            long col = n - row;
            long total = (row + 1) * (col + 1);
            if (total > k) {
                r = row - 1;
            } else if (total < k) {
                l = row + 1;
            } else {
                canCut = true;
                break;
            }
        }

        if (canCut) System.out.println("YES");
        else System.out.println("NO");
        br.close();
    }
}