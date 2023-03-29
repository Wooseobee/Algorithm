import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] rightWall = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            breakWall(x, y, rightWall);
        }

        System.out.println(countRoom(n, rightWall));
        br.close();
    }

    private static int countRoom(int n, boolean[] rightWall) {
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (!rightWall[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    private static void breakWall(int x, int y, boolean[] rightWall) {
        for (int i = x; i < y; i++) {
            rightWall[i] = true;
        }
    }
}