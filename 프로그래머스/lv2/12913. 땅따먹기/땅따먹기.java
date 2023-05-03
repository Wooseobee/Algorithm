class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int r = land.length;
        int[] dp = new int[4];
        for (int i = 0; i < 4; i++) {
            dp[i] = land[0][i];
        }

        /**
         * 0번 칸은 1번,2번,3번 칸 중 선택
         * 1번 칸은 0번,2번,3번 칸 중 선택
         * 2번 칸은 0번,1번,3번 칸 중 선택
         * 3번 칸은 0번,1번,2번 칸 중 선택
         *
         */
        int[][] choice = new int[][]{{1, 2, 3}, {0, 2, 3}, {0, 1, 3}, {0, 1, 2}};

        for (int i = 1; i < r; i++) {
            int[] prev = new int[4];
            System.arraycopy(dp, 0, prev, 0, 4);
            for (int j = 0; j < 4; j++) {
                dp[j] = Math.max(prev[choice[j][0]], Math.max(prev[choice[j][1]], prev[choice[j][2]])) + land[i][j];
            }
        }

        return Math.max(Math.max(dp[0], dp[1]), Math.max(dp[2], dp[3]));
    }
}