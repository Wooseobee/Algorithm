class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] dp = new int[len][len];
        dp[0][0]=triangle[0][0];
        for(int i=1;i<len;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j] = dp[i-1][0];
                } else if(j==i){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
                dp[i][j] += triangle[i][j];
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }
}