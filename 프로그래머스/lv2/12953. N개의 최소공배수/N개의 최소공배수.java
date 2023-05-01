class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = answer * arr[i] / GCD(answer, arr[i]);
        }

        return answer;
    }

    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}