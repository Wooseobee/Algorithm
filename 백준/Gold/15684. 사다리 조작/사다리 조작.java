import java.io.*;
import java.util.*;

public class Main {

    private static int n, m, h;
    private static boolean canLadder = false;
    private static int[][] ladder;  // -1 : 왼쪽으로 사다리, 0 : 사다리 없음, 1 : 오른쪽으로 사다리
    private static List<int[]> choice;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[2]);
        m = Integer.parseInt(in[0]);
        h = Integer.parseInt(in[1]);
        ladder = new int[n][m];

        for (int i = 0; i < h; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]) - 1;
            int b = Integer.parseInt(in[1]) - 1;

            ladder[a][b] = 1;
            ladder[a][b + 1] = -1;
        }

        for (int i = 0; i <= 3; i++) {
            choice = new ArrayList<>();
            comb(0, 0, i);
            if (canLadder) {
                System.out.println(i);
                break;
            }
        }
        if (!canLadder) System.out.println("-1");
        br.close();
    }

    private static void comb(int depth, int sI, int max) {
        if (canLadder) return;
        if (depth == max) {
            if (checkLadder()) canLadder = true;
            return;
        }
        for (int i = sI; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                    ladder[i][j] = 1;
                    ladder[i][j + 1] = -1;

                    comb(depth + 1, i, max);

                    ladder[i][j] = 0;
                    ladder[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean checkLadder() {
        for (int i = 0; i < m; i++) {
            int sI = i;
            for (int j = 0; j < n; j++) {
                int dir = ladder[j][sI];
                if (dir != 0) {
                    if (dir == -1) {
                        sI--;
                    } else {
                        sI++;
                    }
                }
            }
            if (i != sI) return false;
        }
        return true;
    }
}