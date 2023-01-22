import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        citations = Arrays.stream(citations)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = citations.length; i >= 0; i--) {
            int cnt = 0;
            for (int num : citations) {
                if (i <= num) {
                    cnt++;
                }
            }
            if (cnt >= i) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}