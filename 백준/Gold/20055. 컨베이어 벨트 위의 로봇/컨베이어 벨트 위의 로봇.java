import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]) * 2;
        int k = Integer.parseInt(in[1]);
        int[] durability = new int[n + 1];
        boolean[] robot = new boolean[n / 2 + 1];
        int zeros = 0;
        int steps = 0;

        in = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            durability[i + 1] = Integer.parseInt(in[i]);
        }

        while (zeros < k) {
            durability[0] = durability[n];
            zeros = 0;
            // 벨트 회전
            for (int i = n - 1; i >= 0; i--) {
                durability[i + 1] = durability[i];
                if (i < n / 2) {
                    robot[i + 1] = robot[i];
                }
            }

            if (robot[n / 2]) {
                robot[n / 2] = false;
            }

            // 로봇 이동
            for (int i = n / 2 - 1; i > 0; i--) {
                if (robot[i] && !robot[i + 1]) {
                    if (durability[i + 1] >= 1) {
                        robot[i + 1] = true;
                        robot[i] = false;
                        durability[i + 1]--;
                    }
                }
            }

            // 로봇 올리기
            if (durability[1] >= 1) {
                durability[1]--;
                robot[1] = true;
            }

            // 내구도 확인
            for (int i = 1; i <= n; i++) {
                if (durability[i] == 0) {
                    zeros++;
                }
            }
            steps++;
        }

        System.out.println(steps);
        br.close();
    }
}
