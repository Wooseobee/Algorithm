import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int test_case = sc.nextInt();
        for (int t = 1; t <= test_case; t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int l = 1;
            int min = 2_001;

            for (int i = 0; i < n; i++) {
                Arrays.fill(arr[i], 2_001);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++, l++) {
                    int v = sc.nextInt();
                    if (v == 1) {
                        arr[i][j] = v;
                    }
                }
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                int total = 0;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    total += arr[i][j];
                }
                min = Math.min(min, total);
            }

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}