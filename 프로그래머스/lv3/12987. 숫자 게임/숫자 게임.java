import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0, j = 0; i < A.length && j < B.length; i++) {
            while (j < B.length && A[i] >= B[j]) {
                j++;
            }
            if (j < B.length && A[i] < B[j]) {
                answer++;
                j++;
            }
        }
        return answer;
    }
}