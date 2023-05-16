class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = func(numbers[i]);
        }
        return answer;
    }

    private static long func(long num) {
        if (num % 2 == 0) return num + 1;   // 짝수면 +1하고 반환

        String s = "0" + Long.toBinaryString(num);
        int idx = s.lastIndexOf("0");
        return Long.parseLong(s.substring(0, idx) + "10" + s.substring(idx + 2), 2);
    }
}