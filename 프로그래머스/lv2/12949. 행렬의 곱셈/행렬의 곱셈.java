class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int c2 = arr2[0].length;
        int[][] answer = new int[r1][c2];

        for (int j = 0; j < r1; j++) {
            for (int k = 0; k < c2; k++) {
                for (int l = 0; l < c1; l++) {
                    answer[j][k] += arr1[j][l] * arr2[l][k];
                }
            }
        }

        return answer;
    }
}