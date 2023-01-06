import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] notPrime = new boolean[1_000_001];

    public static void main(String[] args) throws IOException {

        for (int i = 2; i * i < notPrime.length; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < notPrime.length; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            findPartition(n / 2);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void findPartition(int mid) throws IOException {
        int left = mid, right = mid, cnt = 0;
        while (left >= 2) {
            if (!notPrime[left] && !notPrime[right]) {
                cnt++;
            }
            left--;
            right++;
        }
        bw.write(cnt + "\n");
    }
}