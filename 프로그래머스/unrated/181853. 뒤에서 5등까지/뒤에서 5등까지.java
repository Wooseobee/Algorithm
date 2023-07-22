import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        num_list = Arrays.stream(num_list).boxed().sorted().mapToInt(Integer::intValue).toArray();
        int[] answer = new int[5];
        for(int i = 0 ; i < 5 ; i ++) {
            answer[i] = num_list[i];
        }
        return answer;
    }
}