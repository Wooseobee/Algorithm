class Solution {
    static int[][] dir = {{1, 0}, {0, 1}, {-1, -1}};

    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] tmp = new int[n][n];
        for (int i = 0, j = 0, v = 1, d = 0; v <= answer.length; v++) {
            tmp[i][j] = v;
            int newI = i + dir[d][0];
            int newJ = j + dir[d][1];
            if (!(newI >= 0 && newJ >= 0 && newI < n && newJ < n && tmp[newI][newJ] == 0)) {
                d = (d + 1) % 3;
            }
            i = i + dir[d][0];
            j = j + dir[d][1];
        }
        for (int i = 0, k = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] != 0) answer[k++] = tmp[i][j];
                else break;
            }
        }
        return answer;
    }
}