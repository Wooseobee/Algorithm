import java.util.stream.*;

class Solution {
    public int solution(int n, int t) {
        return IntStream.range(0, t).reduce(n, (a, b) -> a *= 2);
    }
}