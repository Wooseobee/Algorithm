class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();

        int move = len - 1;
        for (int i = 0; i < len; i++) {
            answer += Math.min(Math.abs(name.charAt(i) - 'A'), Math.abs(name.charAt(i) - 'Z') + 1);

            int endA = i + 1;
            while (endA < len && name.charAt(endA) == 'A') {
                endA++;
            }
            move = Math.min(move, i * 2 + (len - endA));
            move = Math.min(move, i + (len - endA) * 2);
        }

        System.out.println(answer + move);
        return answer + move;
    }
}