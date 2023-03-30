import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int i;
        int j;
        int size;
        int eatCount;

        public Shark(int i, int j, int size, int eatCount) {
            this.i = i;
            this.j = j;
            this.size = size;
            this.eatCount = eatCount;
        }
    }

    static class Point {
        int i;
        int j;
        int dist;

        public Point(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    static int n, time = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static Shark shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0);
                }
            }
        }

        System.out.println(eatFish());
        br.close();
    }

    private static int eatFish() {
        int[] minDist = searchFish();
        while (!(minDist[0] == -1 && minDist[1] == -1)) {
            moveShark(minDist);
            minDist = searchFish();
        }
        return time;
    }

    private static void moveShark(int[] minDist) {
        int i = minDist[0];
        int j = minDist[1];
        int size = shark.size;
        int eatCount = shark.eatCount + 1;

        if (size == eatCount) {
            size++;
            eatCount = 0;
        }

        shark = new Shark(i, j, size, eatCount);
    }

    private static int[] searchFish() {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.dist == o2.dist) {
                if (o1.i == o2.i) {
                    return o1.j - o2.j;
                }
                return o1.i - o2.i;
            }
            return o1.dist - o2.dist;
        });
        boolean[][] visited = new boolean[n][n];
        int sharkI = shark.i;
        int sharkJ = shark.j;
        map[sharkI][sharkJ] = 0;
        int sharkSize = shark.size;
        pq.add(new Point(sharkI, sharkJ, 0));
        visited[sharkI][sharkJ] = true;
        while (!pq.isEmpty()) {
            Point p = pq.poll();

            if (map[p.i][p.j] != 0 && map[p.i][p.j] < sharkSize) {
                time += p.dist;
                return new int[]{p.i, p.j};
            }

            for (int k = 0; k < 4; k++) {
                int i = p.i + dy[k];
                int j = p.j + dx[k];
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    if (map[i][j] <= sharkSize && !visited[i][j]) {
                        pq.add(new Point(i, j, p.dist + 1));
                        visited[i][j] = true;
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
}