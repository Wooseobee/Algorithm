import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class emoticon {
        int clipboard;
        int screen;
        int time;

        public emoticon(int clipboard, int screen, int time) {
            this.clipboard = clipboard;
            this.screen = screen;
            this.time = time;
        }
    }
    static int s;
    static boolean[][] visited = new boolean[1_001][1_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = Integer.parseInt(br.readLine());

        bfs(1);

        br.close();
    }

    static void bfs(int v) {
        Queue<emoticon> q = new LinkedList<>();
        q.add(new emoticon(0, 1, 0));

        while (!q.isEmpty()) {
            emoticon e = q.poll();
            int nowClip = e.clipboard;
            int nowScreen = e.screen;
            int nowTime = e.time;

            if (nowScreen == s) {
                System.out.println(nowTime);
                return;
            }

            if (visited[nowClip][nowScreen]) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    q.add(new emoticon(nowScreen, nowScreen, nowTime + 1));
                } else if (i == 1 && nowClip != 0 && nowScreen + nowClip <= 1000) {
                    q.add(new emoticon(nowClip, nowScreen + nowClip, nowTime + 1));
                } else {
                    if (nowScreen - 1 >= 0) {
                        q.add(new emoticon(nowClip, nowScreen - 1, nowTime + 1));
                    }
                }
            }
            visited[nowClip][nowScreen] = true;
        }
    }
}