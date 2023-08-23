import java.io.*;
import java.util.*;

public class Main {
    static int n, d, k, c, max;
    static int[] sushi, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        max = 0;

        sushi = new int[n];
        visited = new int[d + 1];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        slide();
        System.out.println(max);
        br.close();
    }

    private static void slide() {
        int total = 0;
        for (int i = 0; i < k; i++) {
            if (visited[sushi[i]] == 0) total++;
            visited[sushi[i]]++;
        }
        if (visited[c]==0) max = total +1;
        else max = total;

        for (int i = 1; i < n; i++) {
            visited[sushi[i - 1]]--;
            if (visited[sushi[i - 1]] == 0) total--;
            if (visited[sushi[(i + k - 1) % n]] == 0) total++;
            visited[sushi[(i + k - 1) % n]]++;
            if (max <= total) {
                if (visited[c] == 0) max = total + 1;
                else max = total;
            }
        }
    }
}