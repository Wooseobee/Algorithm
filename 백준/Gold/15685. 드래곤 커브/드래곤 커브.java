import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new boolean[101][101];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            setDragonCurve(y, x, d, g);
        }

        System.out.println(countSquare());
        br.close();
    }

    private static int countSquare() {
        int total = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    total++;
                }
            }
        }

        return total;
    }

    private static void setDragonCurve(int y, int x, int d, int g) {
        List<Integer> dragon = new ArrayList<>();
        dragon.add(d);
        map[y][x] = true;
        y += dx[d];
        x += dy[d];
        map[y][x] = true;
        for (int i = 1; i <= g; i++) {
            int[] newPoint = rotateDragonCurve(y, x, dragon);
            y = newPoint[0];
            x = newPoint[1];
        }
    }

    private static int[] rotateDragonCurve(int y, int x, List<Integer> dragon) {
        int size = dragon.size();
        for (int i = size - 1; i >= 0; i--) {
            int d = (dragon.get(i) + 1) % 4;
            map[y + dx[d]][x + dy[d]] = true;
            y += dx[d];
            x += dy[d];
            dragon.add(d);
        }
        return new int[]{y, x};
    }
}