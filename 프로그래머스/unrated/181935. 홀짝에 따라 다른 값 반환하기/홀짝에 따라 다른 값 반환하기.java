import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return n % 2 == 0 ? IntStream.rangeClosed(1, n).filter(i -> i % 2 == 0).reduce(0, (v1, v2) -> v1 + (int) Math.pow(v2, 2)) : IntStream.rangeClosed(1, n).filter(i -> i % 2 != 0).sum();
    }
}