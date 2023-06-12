import java.util.stream.LongStream;

class Solution {
    public long solution(int a, int b) {
        return a < b ? LongStream.rangeClosed(a, b).sum() : LongStream.rangeClosed(b, a).sum();
    }
}