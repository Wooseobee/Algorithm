class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = func(numbers[i]);
        }
        return answer;
    }

    private static long func(long num) {
        if (num % 2 == 0) return num + 1;

        String s = Long.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        int j = 0;
        boolean found = false;
        for (int i = s.length() - 1; i >= 0; i--, j++) {
            if (s.charAt(i) == '0' && !found) {
                if (j == 0) return num + 1;
                sb.setCharAt(j-1, '0');
                sb.append("1");
                found = true;
                continue;
            }
            sb.append(s.charAt(i));
        }
        if (!found) {
            sb.setCharAt(j - 1, '0');
            sb.append("1");

        }
        return Long.parseLong(sb.reverse().toString(), 2);
    }
}