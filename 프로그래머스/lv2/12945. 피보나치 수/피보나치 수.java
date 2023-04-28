class Solution {
    static int[] dp;
    public int solution(int n) {
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        return Fibo(n);
    }
    public int Fibo(int n){
        if(dp[n]!=0) {
            return dp[n];
        }
        
        return  dp[n] = (Fibo(n-1) + Fibo(n-2)) % 1_234_567;
    }
}