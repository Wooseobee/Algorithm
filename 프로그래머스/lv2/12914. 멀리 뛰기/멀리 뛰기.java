class Solution {
    public long solution(int n) {
        final int MOD = 1_234_567;
        long answer = 0;

        long[] arr = new long[n + 1];
        arr[0] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = (arr[i + 1] + arr[i]) % MOD;
            if (i + 2 <= n) arr[i + 2] = (arr[i + 2] + arr[i]) % MOD;
        }
        return arr[n];
    }
}