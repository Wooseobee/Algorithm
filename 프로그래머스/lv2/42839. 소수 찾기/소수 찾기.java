import java.util.HashSet;
import java.util.Set;

class Solution {
    static String str = "";
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;

    public int solution(String numbers) {
        String[] num = numbers.split("");
        visited = new boolean[numbers.length()];

        for (int i = 1; i <= num.length; i++) {
            comb(0, i, num);
        }

        return set.size();
    }

    static void comb(int size, int n, String[] num) {
        if (size == n) {
            if (isPrime(Integer.parseInt(str))) set.add(Integer.parseInt(str));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                str = str.concat(num[i]);
                comb(size + 1, n, num);
                str = str.substring(0, str.length() - 1);
                
                visited[i] = false;
            }
        }
    }

    static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}