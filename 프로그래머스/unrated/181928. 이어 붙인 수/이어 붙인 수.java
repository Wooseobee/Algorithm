import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        return Integer.parseInt(Arrays.toString(Arrays.stream(num_list).filter(i -> i % 2 == 1).toArray()).replaceAll("[^0-9]", ""))
            + Integer.parseInt(Arrays.toString(Arrays.stream(num_list).filter(i -> i % 2 == 0).toArray()).replaceAll("[^0-9]", ""));
    }
}