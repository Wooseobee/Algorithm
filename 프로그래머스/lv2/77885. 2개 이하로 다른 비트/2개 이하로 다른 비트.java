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

        String s = Long.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        int j = 0;
        boolean found = false;
        for (int i = s.length() - 1; i >= 0; i--, j++) {
            if (s.charAt(i) == '0' && !found) {     // 현재 숫자가 0이면 현재 숫자 1로 바꾸고 바로 이전 숫자 0으로 바꾸기 ex) 11011 => 11101, 110011 => 110101
                if (j == 0) return num + 1;     // 첫번째 수가 0이면 +1하고 반환
                sb.setCharAt(j - 1, '0');
                sb.append("1");
                found = true;
                continue;
            }
            sb.append(s.charAt(i));
        }
        if (!found) {   // 모두 1이면 앞에 1 추가하고 바로 이전 숫자 0으로 바꾸기 ex) 111 => 1011
            sb.setCharAt(j - 1, '0');
            sb.append("1");

        }
        return Long.parseLong(sb.reverse().toString(), 2);
    }
}