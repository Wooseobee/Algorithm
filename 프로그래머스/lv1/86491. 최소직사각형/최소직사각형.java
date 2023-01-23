class Solution {
    public int solution(int[][] sizes) {
        int x = 0, y = 0;

        for (int[] card : sizes) {
            x = Math.max(x, Math.max(card[0], card[1]));
            y = Math.max(y, Math.min(card[0], card[1]));
        }

        return x * y;
    }
}