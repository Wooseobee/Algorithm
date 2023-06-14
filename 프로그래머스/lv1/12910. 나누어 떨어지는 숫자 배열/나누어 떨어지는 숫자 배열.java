import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] array = Arrays.stream(arr).sorted().filter(i -> i % divisor == 0).toArray();
        return array.length != 0 ? array : new int[]{-1};
    }
}