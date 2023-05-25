import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // 2
        Arrays.sort(data, new Comparator<>() {
            @Override
            public int compare(int[] d1, int[] d2) {
                if (d1[col - 1] == d2[col - 1]) {
                    return d2[0] - d1[0];
                }
                return d1[col - 1] - d2[col - 1];
            }
        });

        // 3
        for (int i = row_begin; i <= row_end; i++) {
            int total = 0;
            for (int j = 0; j < data[i - 1].length; j++) {
                total += data[i - 1][j] % i;
            }
            answer = answer ^ total;
        }

        return answer;
    }
}