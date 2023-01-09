import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static int solution(int n, int k) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add(n % k);
            n /= k;
        }

        Collections.reverse(list);

        List<Integer> prime = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                prime.add(list.get(i));
            } else {
                if (!prime.isEmpty()) {
                    if (checkPrime(prime)) answer++;
                }
                prime.clear();
            }
        }

        if (!prime.isEmpty()) {
            if (checkPrime(prime)) answer++;
        }

        return answer;
    }

    static boolean checkPrime(List<Integer> prime) {
        String s = "";
        for (int i = 0; i < prime.size(); i++) {
            s = s.concat(String.valueOf(prime.get(i)));
        }
        long value = Long.parseLong(s);
        if (value == 1) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}