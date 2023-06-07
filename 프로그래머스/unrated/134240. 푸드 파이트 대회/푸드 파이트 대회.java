import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] food) {
        Deque<String> answer = new LinkedList<>();
        answer.add("0");
        for (int i = food.length - 1; i > 0; i--) {
            int cnt = food[i] / 2;
            for (int j = 0; j < cnt; j++) answer.addFirst(String.valueOf(i));
            for (int j = 0; j < cnt; j++) answer.addLast(String.valueOf(i));
        }
        return answer.stream().collect(Collectors.joining());
    }
}