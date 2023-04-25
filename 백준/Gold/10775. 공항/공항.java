import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int[] parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        for (int i = 1; i <= P; i++) {
            int g = Integer.parseInt(br.readLine());
            int x = find(parent, g);
            if (x == 0) {
                break;
            }
            parent[x] = find(parent, x) - 1;
            cnt++;
        }
        System.out.println(cnt);
        br.close();
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }
}