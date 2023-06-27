import java.util.Collections;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int start, int end) {
        return IntStream.rangeClosed(end, start).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
    }
}