import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        score = Arrays.stream(score)
            .boxed().sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue).toArray();
        
        for(int i = 0; i < score.length; i += m) {
            if(i + m > score.length) break;
            answer += score[i + m - 1] * m;
        }
        return answer;
    }
}