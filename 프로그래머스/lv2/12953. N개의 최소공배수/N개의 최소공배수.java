import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        boolean[] notPrime = new boolean[101];

        for (int i = 2; i <= 100; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= 100; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        for (int i = 2; i <= 100; i++) {
            if (!notPrime[i]) {
                int divCnt = 0;
                int[] tmp = Arrays.copyOf(arr, arr.length);
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] % i == 0) {
                        arr[j] /= i;
                        divCnt++;
                    }
                }
                if (divCnt > 1) {
                    answer *= i;
                    i--;
                } else arr = Arrays.copyOf(tmp, tmp.length);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            answer *= arr[i];
        }

        return answer;
    }
}