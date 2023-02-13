import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static int[][] arr;
    static List<Integer> list = new ArrayList<>();

    public int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows + 1][columns + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = (i - 1) * columns + j;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            rotation(rows, columns, queries[i]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void rotation(int rows, int columns, int[] query) {
        int[][] tmp = new int[rows + 1][columns + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                int tmpNum = arr[i][j];
                tmp[i][j] = tmpNum;
            }
        }

        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];
        int min = 10_001;

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (i == x1) {
                    if (j == y1) {
                        arr[i][j] = tmp[i + 1][j];
                    } else {
                        arr[i][j] = tmp[i][j - 1];
                    }
                    min = Math.min(min, tmp[i][j]);
                } else if (i == x2) {
                    if (j == y2) {
                        arr[i][j] = tmp[i - 1][j];
                    } else {
                        arr[i][j] = tmp[i][j + 1];
                    }
                    min = Math.min(min, tmp[i][j]);
                } else if (j == y1) {
                    arr[i][j] = tmp[i + 1][j];
                    min = Math.min(min, tmp[i][j]);
                } else if (j == y2) {
                    arr[i][j] = tmp[i - 1][j];
                    min = Math.min(min, tmp[i][j]);
                }
            }
        }
        list.add(min);
    }
}