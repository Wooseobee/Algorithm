import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] arrA = new int[n][m];
        int[][] arrB = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arrA[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arrB[i][j] = Integer.parseInt(input[j]);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 2 < n && j + 2 < m) {
                    if (arrA[i][j] != arrB[i][j]) {
                        cnt++;
                        for (int k = i; k < i + 3; k++) {
                            for (int l = j; l < j + 3; l++) {
                                if (arrA[k][l] == 0) {
                                    arrA[k][l] = 1;
                                } else {
                                    arrA[k][l] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (isSameArr(arrA, arrB, n, m)) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
        br.close();
    }

    private static boolean isSameArr(int[][] arrA, int[][] arrB, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrA[i][j] != arrB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}