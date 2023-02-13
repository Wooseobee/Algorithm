import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long left = 0;
        long right = (long) Math.sqrt(n);
        long mid;
        
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid * mid < n) {
                left = mid + 1;
            } else if (mid * mid > n) {
                right = mid - 1;
            } else {
                left = mid;
                break;
            }
        }

        System.out.println(left);
        br.close();
    }
}