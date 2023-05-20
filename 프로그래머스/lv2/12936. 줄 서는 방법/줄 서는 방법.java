import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static List<Integer> answer = new ArrayList<>();
    static List<Integer> numList = new ArrayList<>();

    public int[] solution(int n, long k) {
        int[] ans = new int[n];

        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }

        long min = factorial(n - 1);
        long total = 0;
        while (answer.size() < n) {
            int cnt = 0;
            while (total < k) {
                if (total + min < k) {
                    total += min;
                    cnt++;
                } else {
                    break;
                }
            }
            if (answer.size() + 1 < n) {
                answer.add(numList.get(cnt));
                min /= (n - answer.size());
                numList.remove(cnt);
            } else {
                answer.add(numList.get(0));
            }
        }

        for (int i = 0; i < n; i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }

    private static long factorial(int n) {
        long total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;
        }
        return total;
    }
}