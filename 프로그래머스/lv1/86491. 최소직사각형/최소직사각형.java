class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0, min = 1_001;

        for (int i = 0; i < sizes.length; i++) {
            if (max < sizes[i][0]) {
                max = sizes[i][0];
                min = sizes[i][1];
            }
            if (max < sizes[i][1]) {
                max = sizes[i][1];
                min = sizes[i][0];
            }
        }

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > min && sizes[i][1] > min) {
                min = Math.min(sizes[i][0], sizes[i][1]);
            }
        }

        return max * min;
    }
}