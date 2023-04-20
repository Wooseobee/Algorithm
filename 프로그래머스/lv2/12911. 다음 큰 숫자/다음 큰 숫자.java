class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        int tmp = n;
        while(tmp>0){
            if(tmp%2!=0) cnt++;
            tmp/=2;
        }
        for(int i=n+1;;i++){
            tmp = i;
            int cnt2 = 0;
            while(tmp>0){
                if(tmp%2!=0) cnt2++;
                tmp/=2;
            }
            if(cnt==cnt2) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}