import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return n % 2 == 0 ? IntStream.rangeClosed(1, n).filter(i -> i % 2 == 0).map(i -> (int) Math.pow(i, 2)).sum() : IntStream.rangeClosed(1, n).filter(i -> i % 2 != 0).sum();
    }
}