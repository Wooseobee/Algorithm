import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Arrays.sort(lottos);
        Arrays.sort(lottos);
        
        int cnt = 0;
        int sameNum = 0;
        for(int i=0;i<6;i++){
            if(lottos[i]==0){
                cnt++;
            }
            for(int j=0;j<6;j++){
                if(lottos[i]==win_nums[j]){
                    sameNum++;
                }
            }
        }
        
        answer[0]=cal(cnt+sameNum);
        answer[1]=cal(sameNum);
        
        return answer;
    }
    static int cal(int sameNum){
        switch(sameNum){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}