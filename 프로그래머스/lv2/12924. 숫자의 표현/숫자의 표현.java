class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1;i<=n;i++){
            int sum = 0;
            int e = i;
            while(e <= n && sum < n){
                sum+=e++;
                if(sum==n){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}