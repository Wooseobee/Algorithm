import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int n) {
        if (arr.length % 2 == 0) {
            return IntStream.range(0, arr.length).map(i -> {
                if (i % 2 == 0) {
                    return arr[i];
                } else {
                    return arr[i] + n;
                }
            }).toArray();
        } else {
            return IntStream.range(0, arr.length).map(i -> {
                if (i % 2 != 0) {
                    return arr[i];
                } else {
                    return arr[i] + n;
                }
            }).toArray();
        }
    }
}