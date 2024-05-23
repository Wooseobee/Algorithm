import java.io.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int H = Integer.parseInt(input[1]);
        int[] up = new int[H + 1];
        int[] down = new int[H + 1];
        int[] total = new int[H + 1];
        int upCount = N / 2;
        int downCount = N / 2;
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int y = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                up[y]++;
            } else {
                down[H - y + 1]++;
            }
        }

        // 석순 확인
        for (int i = 1; i <= H; i++) {
            total[i] += upCount;
            upCount -= up[i];
        }

        // 종유석 확인
        for (int i = H; i >= 1; i--) {
            total[i] += downCount;
            downCount -= down[i];
            if (min > total[i]) {
                min = total[i];
                cnt = 1;
            } else if (min == total[i]) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
        br.close();
    }
}