import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(findLastNum(0, 0, n));

        br.close();
    }

    static int findLastNum(int i, int j, int size) {
        if (size == 2) {
            return findSecondNum(i, j);
        }
        int a1 = findLastNum(i, j, size / 2);
        int a2 = findLastNum(i, j + size / 2, size / 2);
        int a3 = findLastNum(i + size / 2, j, size / 2);
        int a4 = findLastNum(i + size / 2, j + size / 2, size / 2);

        int[] compareArr = new int[4];

        compareArr[0] = a1;
        compareArr[1] = a2;
        compareArr[2] = a3;
        compareArr[3] = a4;

        Arrays.sort(compareArr);

        return compareArr[2];
    }

    static int findSecondNum(int i, int j) {
        int[] compareArr = new int[4];
        int idx = 0;
        for (int k = i; k <= i + 1; k++) {
            for (int l = j; l <= j + 1; l++) {
                compareArr[idx++] = arr[k][l];
            }
        }

        Arrays.sort(compareArr);

        return compareArr[2];
    }
}