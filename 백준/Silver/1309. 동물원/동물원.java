import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /**
         * zoo[i][0] => i번째 줄에 사자를 넣지 않는 경우
         * zoo[i][1] => i번째 줄 왼쪽에 사자를 넣는 경우
         * zoo[i][2] => i번째 줄 오른쪽에 사자를 넣는 경우
         */
        int[][] zoo = new int[n + 1][3];

        Arrays.fill(zoo[1], 1);

        int total = 3;
        for (int i = 2; i <= n; i++) {
            zoo[i][0] = (zoo[i - 1][0] + zoo[i - 1][1] + zoo[i - 1][2]) % 9_901;
            zoo[i][1] = (zoo[i - 1][0] + zoo[i - 1][2]) % 9_901;
            zoo[i][2] = (zoo[i - 1][0] + zoo[i - 1][1]) % 9_901;
            if (i == n) {
                total += (zoo[i][0] + zoo[i][1] + zoo[i][2]) % 9_901;
                total -= 3;
            }
        }

        System.out.println(total);
        br.close();
    }
}