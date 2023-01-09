class Solution {
    public static int solution(int n, int k) {
        int answer = 0;

        String[] s = Integer.toString(n, k).split("0");

        for (String str : s) {
            if (str.length() != 0 && checkPrime(str)) {
                answer++;
            }
        }

        return answer;
    }

    static boolean checkPrime(String s) {
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