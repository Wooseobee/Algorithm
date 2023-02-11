class Solution {
    static int[] moveX = new int[]{-1, 1};

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            students[i] = 1;
        }

        for (int l : lost) {
            students[l] = 0;
        }

        for (int r : reserve) {
            students[r]++;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                if (i + moveX[j] >= 1 && i + moveX[j] <= n && students[i] > 1 && students[i + moveX[j]] == 0) {
                    students[i]--;
                    students[i + moveX[j]]++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}