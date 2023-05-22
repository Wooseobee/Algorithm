import java.util.*;

class Solution {
    static int[][] dir = {{1, 0}, {0, 1}, {-1, -1}};

    public int[] solution(int n) {
        int[][] answer = new int[n][n];
        int len = n * (n + 1) / 2;
        
        for (int i = 0, j = 0, v = 1, d = 0; v <= len; v++) {
            answer[i][j] = v;
            int newI = i + dir[d][0];
            int newJ = j + dir[d][1];
            if (!(newI >= 0 && newJ >= 0 && newI < n && newJ < n && answer[newI][newJ] == 0)) {
                d = (d + 1) % 3;
            }
            i = i + dir[d][0];
            j = j + dir[d][1];
        }
        return Arrays.stream(answer)
                .flatMapToInt(Arrays::stream)
                .filter(o -> o != 0).toArray();
    }
}