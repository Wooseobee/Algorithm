import java.io.*;

public class Main {
    static int r, c, idx = 0, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        moveZ(0, 0, (int) Math.pow(2, n));
        System.out.println(answer);
        br.close();
    }

    static void moveZ(int i, int j, int size) {
        if (size==2){
            findIdx(i, j);
            return;
        }
        if (r >= i && r <= i + size && c >= j && c <= j + size) {
            moveZ(i, j, size / 2);
            moveZ(i, j + size / 2, size / 2);
            moveZ(i + size / 2, j, size / 2);
            moveZ(i + size / 2, j + size / 2, size / 2);
        } else {
            idx += size * size;
        }
    }

    static void findIdx(int i, int j) {
        for (int k = i; k <= i + 1; k++) {
            for (int l = j; l <= j + 1; l++) {
                if (k == r && l == c) {
                    answer = idx;
                    return;
                } else idx++;
            }
        }
    }
}