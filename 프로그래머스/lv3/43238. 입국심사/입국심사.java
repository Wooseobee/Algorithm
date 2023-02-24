class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long maxTime = 0;
        for(int t : times){
            maxTime = Math.max(maxTime, t);
        }
        
        long l = 0;
        long r = n*maxTime;
        
        while(l<r){
            long mid = (l+r)/2;
            long sum = 0;
            for(int t : times){
                sum+=mid/t;
            }
            if(sum<n){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        
        return l;
    }
}