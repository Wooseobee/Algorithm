import java.util.*;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int sum1 = Arrays.stream(arr1).sum();
        int sum2 = Arrays.stream(arr2).sum();
        return arr1.length > arr2.length ? 1 : arr1.length < arr2.length ? -1 : sum1 > sum2 ? 1 : sum1 == sum2 ? 0 : -1;
    }
}