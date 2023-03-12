import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int[] wall = new int[n+1];
        
        Arrays.fill(wall, 1);
        for(int i=0;i<section.length;i++){
            wall[section[i]]=0;
        }
        
        for(int i=1;i<=n;i++){
            if(wall[i]==0){
                for(int j=i;j<=n&&j<i+m;j++){
                    wall[j]=1;
                }
                answer++;
            }
        }
        
        return answer;
    }
}