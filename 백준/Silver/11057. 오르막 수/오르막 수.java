import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][10];

        for (int i = 0; i < 10; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    arr[i][j] += (arr[i - 1][k] % 10_007);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            cnt += arr[n - 1][i];
        }

        System.out.println(cnt % 10_007);
        br.close();
    }
}