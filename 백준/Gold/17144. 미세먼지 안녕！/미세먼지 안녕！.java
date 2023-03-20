import java.io.*;
import java.util.*;

public class Main {
    static int r, c, t;
    static int[][] room;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] airCleaner = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        room = new int[r][c];

        int cnt = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    airCleaner[cnt] = i;
                    cnt++;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            dustMoving();
            airCleanerMoving();
        }

        System.out.println(countDust());
        br.close();
    }

    private static int countDust() {
        int total = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] != -1 && room[i][j] != 0) {
                    total += room[i][j];
                }
            }
        }
        return total;
    }

    private static void airCleanerMoving() {
        int up = airCleaner[0];
        int down = airCleaner[1];

        int i = up - 2;
        int j = 0;

        while (!(i == up && j == 0)) {
            if (j == 0) {
                room[i + 1][j] = room[i][j];
                if (i == 0) {
                    j++;
                } else {
                    i--;
                }
            } else if (j == c - 1) {
                if (i == 0) {
                    room[i][j - 1] = room[i][j];
                    i++;
                } else if (i == up) {
                    room[i - 1][j] = room[i][j];
                    j--;
                } else {
                    room[i - 1][j] = room[i][j];
                    i++;
                }
            } else {
                if (i == 0) {
                    room[i][j - 1] = room[i][j];
                    j++;
                } else {
                    room[i][j + 1] = room[i][j];
                    j--;
                }
            }
        }
        room[up][1] = 0;

        i = down + 2;
        while (!(i == down && j == 0)) {
            if (j == 0) {
                room[i - 1][j] = room[i][j];
                if (i == r - 1) {
                    j++;
                } else {
                    i++;
                }
            } else if (j == c - 1) {
                if (i == r - 1) {
                    room[i][j - 1] = room[i][j];
                    i--;
                } else if (i == down) {
                    room[i + 1][j] = room[i][j];
                    j--;
                } else {
                    room[i + 1][j] = room[i][j];
                    i--;
                }
            } else {
                if (i == r - 1) {
                    room[i][j - 1] = room[i][j];
                    j++;
                } else {
                    room[i][j + 1] = room[i][j];
                    j--;
                }
            }
        }
        room[down][1] = 0;
    }

    private static void dustMoving() {
        int[][] nextRoom = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] != 0 && room[i][j] != -1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nowR = i + dy[k];
                        int nowC = j + dx[k];
                        if (nowR >= 0 && nowC >= 0 && nowR < r && nowC < c) {
                            if (room[nowR][nowC] != -1) {
                                nextRoom[nowR][nowC] += room[i][j] / 5;
                                cnt++;
                            }
                        }
                    }
                    nextRoom[i][j] += room[i][j] - (room[i][j] / 5) * cnt;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            room[i] = Arrays.copyOf(nextRoom[i], c);
        }
        room[airCleaner[0]][0] = -1;
        room[airCleaner[1]][0] = -1;
    }
}