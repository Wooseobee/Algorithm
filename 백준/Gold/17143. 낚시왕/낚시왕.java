import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int r, c, m;
    static int[][] board;
    static List<Shark> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[r + 1][c + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.println(fishing());
        br.close();
    }

    private static int fishing() {
        int weight = 0;
        for (int i = 1; i <= c; i++) {
            list.sort((o1, o2) -> o1.r - o2.r);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).c == i) {
                    weight += list.get(j).z;
                    list.remove(j);
                    break;
                }
            }
            moveSharks();
        }
        return weight;
    }

    private static void moveSharks() {
        for (int i = 0; i < list.size(); i++) {
            Shark shark = list.get(i);
            int y = shark.r;
            int x = shark.c;
            int s = shark.s;
            int d = shark.d;
            int z = shark.z;
            int cycleR = s % (r * 2 - 2);
            int cycleC = s % (c * 2 - 2);

            if (d == 1 || d == 2) {
                for (int j = 0; j < cycleR; j++) {
                    switch (d) {
                        case 1:
                            if (y == 1) {
                                d = 2;
                                y = 2;
                            } else {
                                y--;
                            }
                            break;
                        case 2:
                            if (y == r) {
                                d = 1;
                                y = r - 1;
                            } else {
                                y++;
                            }
                            break;
                    }
                }
            } else {
                for (int j = 0; j < cycleC; j++) {
                    switch (d) {
                        case 3:
                            if (x == c) {
                                d = 4;
                                x = c - 1;
                            } else {
                                x++;
                            }
                            break;
                        case 4:
                            if (x == 1) {
                                d = 3;
                                x = 2;
                            } else {
                                x--;
                            }
                            break;
                    }
                }

            }
            list.set(i, new Shark(y, x, s, d, z));
        }

        eatShark();

    }

    private static void eatShark() {
        list.sort((o1, o2) -> o2.z - o1.z);
        int[][] arr = new int[r + 1][c + 1];
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Shark shark = list.get(i);
            if (arr[shark.r][shark.c] != 0) {
                index.add(i);
            } else {
                arr[shark.r][shark.c] = 1;
            }
        }
        for (int i = 0; i < index.size(); i++) {
            list.remove(index.get(i) - i);
        }
    }
}