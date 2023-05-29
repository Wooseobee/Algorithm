import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // 2
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });

        // 3
        for (int i = row_begin; i <= row_end; i++) {
            int total = 0;
            for (int j = 0; j < data[i - 1].length; j++) {
                total += data[i - 1][j] % i;
            }
            answer ^= total;
        }

        return answer;
    }
}