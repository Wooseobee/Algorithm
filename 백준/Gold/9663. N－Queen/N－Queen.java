import java.io.*;

public class Main {
    static int n, cnt = 0;
    static int[] chess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        chess = new int[n];

        search(0);

        System.out.println(cnt);
    }

    static void search(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            chess[depth] = i;

            if (checkBoard(depth)) {
                search(depth + 1);
            }
        }
    }

    static boolean checkBoard(int depth) {
        for (int i = 0; i < depth; i++) {
            if (chess[depth] == chess[i]) {
                return false;
            } else if (Math.abs(depth - i) == Math.abs(chess[depth] - chess[i])) {
                return false;
            }
        }
        return true;
    }
}