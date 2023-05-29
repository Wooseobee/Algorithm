import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        return Arrays.stream(array).filter(v -> v == n).toArray().length;
    }
}