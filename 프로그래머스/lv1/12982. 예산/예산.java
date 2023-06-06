import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        d = Arrays.stream(d)
                .boxed().sorted()
                .mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < d.length; i++) {
            budget -= d[i];
            answer++;
            if (budget < 0) return i;
        }
        return answer;
    }
}