import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        int[] answer = new int[arr.length - 1];
        int min = Arrays.stream(arr).min().getAsInt();
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (min == arr[i]) continue;
            answer[j++] = arr[i];
        }
        return answer;
    }
}