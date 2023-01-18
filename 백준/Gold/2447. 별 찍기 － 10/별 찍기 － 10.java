import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static String[][] stars;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        stars = new String[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(stars[i], " ");
        }

        star(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(stars[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void star(int i, int j, int size) throws IOException {
        if (size == 1) {
            stars[i][j] = "*";
            return;
        }
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (!(k == 1 && l == 1)) {
                    star(i + k * (size / 3), j + l * (size / 3), size / 3);
                }
            }
        }
    }
}