import java.io.*;
import java.util.*;

public class Main {
    static class Room {
        boolean leftWall;
        boolean rightWall;

        public Room(boolean leftWall, boolean rightWall) {
            this.leftWall = leftWall;
            this.rightWall = rightWall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Room[] room = new Room[n + 1];
        for (int i = 1; i <= n; i++) {
            room[i] = new Room(true, true);
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            breakWall(x, y, room);
        }

        System.out.println(countRoom(n, room));
        br.close();
    }

    private static int countRoom(int n, Room[] room) {
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (room[i].rightWall) {
                cnt++;
            }
        }
        return cnt;
    }

    private static void breakWall(int x, int y, Room[] room) {
        for (int i = x; i < y; i++) {
            room[i].rightWall = false;
            room[i + 1].leftWall = false;
        }
    }
}