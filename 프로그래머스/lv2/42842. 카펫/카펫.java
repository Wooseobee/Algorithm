class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x, y;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                x = Math.max(i, yellow / i);
                y = Math.min(i, yellow / i);
                if ((x + 2) * (y + 2) == brown + yellow) {
                    answer[0] = x + 2;
                    answer[1] = y + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}