import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int[] idx = {0};
        int a = Arrays.stream(num_list).filter(i -> idx[0]++ % 2 == 0).sum();
        idx[0] = 0;
        int b = Arrays.stream(num_list).filter(i -> idx[0]++ % 2 != 0).sum();
        return a > b ? a : b;
    }
}