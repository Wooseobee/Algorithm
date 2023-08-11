import java.io.*;
import java.util.*;

class Main {
    private static int m;
    private static int min = Integer.MAX_VALUE;
    private static int[] selected;
    private static List<int[]> homeList;
    private static List<int[]> chickenList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        int[][] city = new int[n][n];
        selected = new int[m];
        homeList = new ArrayList<>();
        chickenList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(in[j]);
                if (city[i][j] == 1) {
                    homeList.add(new int[]{i, j});
                } else if (city[i][j] == 2) {
                    chickenList.add(new int[]{i, j});
                }
            }
        }

        selectChicken(0, 0);

        System.out.println(min);
        br.close();
    }

    private static void selectChicken(int depth, int idx) {
        if (depth == m) {
            min = Math.min(min, countChickenLen());
            return;
        }
        for (int i = idx; i < chickenList.size(); i++) {
            selected[depth] = i;
            selectChicken(depth + 1, i + 1);
        }
    }

    private static int countChickenLen() {
        int len = 0;
        for (int[] home : homeList) {
            int r2 = home[0];
            int c2 = home[1];

            len += countMinLen(r2, c2);
        }
        return len;
    }

    private static int countMinLen(int r1, int c1) {
        int len = Integer.MAX_VALUE;

        for (int i : selected) {
            int[] chickenCoords = chickenList.get(i);
            int r2 = chickenCoords[0];
            int c2 = chickenCoords[1];

            len = Math.min(len, Math.abs(r1 - r2) + Math.abs(c1 - c2));
        }

        return len;
    }
}