import java.io.*;
import java.util.*;

public class Main {
    static int n, m, totalRoom = 0, max = 0, maxRoomSize = 0;
    static int[][] castle;
    static int[][] roomNum;
    static List<Integer> roomSize = new ArrayList<>();
    static boolean[][] visited;
    static int[] moveX = new int[]{0, 1, 0, -1};
    static int[] moveY = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[0]);

        castle = new int[n][m];
        roomNum = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(input[j]);
            }
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, num++);
                    totalRoom++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    int nextI = i + moveY[k];
                    int nextJ = j + moveX[k];
                    if (nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < m) {
                        if (roomNum[i][j] != roomNum[nextI][nextJ]) {
                            maxRoomSize = Math.max(maxRoomSize, roomSize.get(roomNum[i][j]) + roomSize.get(roomNum[nextI][nextJ]));
                        }
                    }
                }
            }
        }

        System.out.println(totalRoom);
        System.out.println(max);
        System.out.println(maxRoomSize);

        br.close();
    }

    static class Room {
        int i;
        int j;

        public Room(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static void bfs(int i, int j, int num) {
        Queue<Room> q = new LinkedList<>();
        q.add(new Room(i, j));
        visited[i][j] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            Room r = q.poll();
            roomNum[r.i][r.j] = num;

            cnt++;

            for (int k = 0; k < 4; k++) {
                int newI = r.i + moveY[k];
                int newJ = r.j + moveX[k];

                if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
                    if (!visited[newI][newJ] && canGo(k, castle[r.i][r.j])) {
                        visited[newI][newJ] = true;
                        q.add(new Room(newI, newJ));
                    }
                }
            }
        }
        roomSize.add(cnt);
        max = Math.max(max, cnt);
    }

    static boolean canGo(int dir, int k) {
        String binary = String.format("%04d", Integer.parseInt(Integer.toBinaryString(k)));
        return binary.charAt(dir) == '0';
    }
}