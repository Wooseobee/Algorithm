class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int left = a < b ? a : b;
        int right = a > b ? a : b;
        while(n>0){
            n/=2;
            if(n!=0 && n<left && n<right){
                left%=n;
                right%=n;
                if(right==0) right=n;
            }
            if(n<right) break;
        }
        
        while(n>0){
            n/=2;
            answer++;
        }

        return answer;
    }
}