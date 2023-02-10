import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dist;
    static final int INF = 4_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        dist = new int[v + 1][v + 1];

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j) dist[i][j] = INF;
            }
        }

        for (int j = 0; j < e; j++) {
            input = br.readLine().split(" ");
            dist[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = Integer.parseInt(input[2]);
        }

        FloydWarshall(v, e);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j) min = Math.min(min, dist[i][j] + dist[j][i]);
            }
        }
        if (min >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
        br.close();
    }

    static void FloydWarshall(int v, int e) {
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (i != j) dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}