import java.io.*;
import java.util.*;

public class Main {

    private static int n, m, l, k;
    private static List<int[]> stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        l = Integer.parseInt(in[2]);
        k = Integer.parseInt(in[3]);
        int ans = 0;
        stars = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            in = br.readLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);

            stars.add(new int[]{x, y});
        }

        for (int[] star1 : stars) {
            int x1 = star1[0];

            int cnt = 0;
            for (int[] star2 : stars) {
                int y2 = star2[1];
                ans = Math.max(ans, foundStar(x1, y2));
            }
        }
        System.out.println(k - ans);
        br.close();
    }

    private static int foundStar(int i, int j) {
        int cnt = 0;
        for (int[] s : stars) {
            if (i <= s[0] && s[0] <= i + l &&
                    j <= s[1] && s[1] <= j + l) {
                cnt++;
            }
        }
        return cnt;
    }
}
