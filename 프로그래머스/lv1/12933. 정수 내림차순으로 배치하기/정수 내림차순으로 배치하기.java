import java.util.*;

class Solution {
    public long solution(long n) {
        return Long.parseLong(new StringBuilder().append(Arrays.toString(Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).boxed().sorted(Collections.reverseOrder()).toArray())).toString().replaceAll("[^0-9]", ""));
    }
}