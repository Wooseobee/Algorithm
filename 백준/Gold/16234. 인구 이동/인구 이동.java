import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, l, r, cnt = 0;
    static int[][] countries;
    static boolean[][] visited;
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        l = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);

        countries = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                countries[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean populationMoved = true;
        while (populationMoved) {
            populationMoved = false;
            cnt++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (openBorderLine(i, j)) populationMoved = true;
                }
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }
        }

        System.out.println(cnt - 1);
        br.close();
    }

    static class Country {
        int x;
        int y;
        int population;

        public Country(int x, int y, int population) {
            this.x = x;
            this.y = y;
            this.population = population;
        }
    }

    static boolean openBorderLine(int i, int j) {
        Queue<Country> q = new LinkedList<>();
        List<Country> list = new ArrayList<>();

        q.add(new Country(j, i, countries[i][j]));
        int total = 0;

        while (!q.isEmpty()) {
            Country country = q.poll();
            int x = country.x;
            int y = country.y;
            int population = country.population;

            if (visited[y][x]) continue;
            visited[y][x] = true;
            list.add(new Country(x, y, countries[y][x]));
            total += countries[y][x];
            for (int k = 0; k < 4; k++) {
                if (x + moveX[k] >= 0 && y + moveY[k] >= 0 && x + moveX[k] < n && y + moveY[k] < n && !visited[y + moveY[k]][x + moveX[k]]) {
                    if (Math.abs(population - countries[y + moveY[k]][x + moveX[k]]) >= l && Math.abs(population - countries[y + moveY[k]][x + moveX[k]]) <= r) {
                        q.add(new Country(x + moveX[k], y + moveY[k], countries[y + moveY[k]][x + moveX[k]]));
                    }
                }
            }
        }

        if (list.size() > 1) {
            total /= list.size();
            for (Country c : list) {
                countries[c.y][c.x] = total;
            }
            return true;
        }
        return false;
    }
}