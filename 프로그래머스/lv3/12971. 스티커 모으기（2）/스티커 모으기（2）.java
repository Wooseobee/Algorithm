class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        if (len == 1) return sticker[0];
        int[] startZero = new int[len];
        int[] startOne = new int[len];
        startZero[0] = sticker[0];
        startZero[1] = sticker[0];
        for (int i = 2; i < len - 1; i++) {
            startZero[i] = Math.max(startZero[i - 1], startZero[i - 2] + sticker[i]);
        }

        startOne[0] = 0;
        startOne[1] = sticker[1];
        for (int i = 2; i < len; i++) {
            startOne[i] = Math.max(startOne[i - 1], startOne[i - 2] + sticker[i]);
        }

        return Math.max(startZero[len - 2], startOne[len - 1]);
    }
}