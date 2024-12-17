import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int bandageCnt = 0;
        int attackCnt = 0;
        int maxTime = 0;
        
        for(int[] attack : attacks) {
            maxTime = Math.max(maxTime, attack[0]);
        }
        
        for(int i = 1; i <= maxTime; i++) {
            int attackTime = attacks[attackCnt][0];
            int damage = attacks[attackCnt][1];
            
            if(i == attackTime) {
                answer -= damage;
                if(answer <= 0) {
                    return -1;
                }
                bandageCnt = 0;
                attackCnt++;
            } else {
                bandageCnt++;
                if(bandageCnt == bandage[0]) {
                    if(answer + bandage[1] + bandage[2] > health) {
                        answer = health;
                    } else {
                        answer += bandage[1] + bandage[2];    
                    }
                    bandageCnt = 0;
                } else {
                    if(answer + bandage[1] > health) {
                        answer = health;
                    } else {
                        answer += bandage[1];
                    }
                }
            }
        }
        
        return answer;
    }
}