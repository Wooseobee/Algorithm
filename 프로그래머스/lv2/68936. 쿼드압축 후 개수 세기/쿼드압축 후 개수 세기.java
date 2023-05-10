class Solution {
    static int zero = 0, one = 0;

    public int[] solution(int[][] arr) {
        solve(arr, 0, 0, arr.length);
        return new int[]{zero, one};
    }

    private static void solve(int[][] arr, int i, int j, int size) {
        if (check(arr, i, j, size)) {
            if (arr[i][j] == 0) zero++;
            else one++;
            return;
        }
        size /= 2;
        solve(arr, i, j, size);
        solve(arr, i + size, j, size);
        solve(arr, i, j + size, size);
        solve(arr, i + size, j + size, size);
    }

    private static boolean check(int[][] arr, int i, int j, int size) {
        int now = arr[i][j];
        for (int k = i; k < i + size; k++) {
            for (int l = j; l < j + size; l++) {
                if (now != arr[k][l]) return false;
            }
        }
        return true;
    }
}