class Solution {
    static int[] tmp = new int[11];
    static int[] answer = new int[11];
    static int apeach, lion, max = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        dfs(0, n, info, 0);

        if (max <= 0) {
            return new int[]{-1};
        } else {
            return answer;
        }
    }

    static void dfs(int idx, int n, int[] info, int cnt) {
        if (cnt == n) {
            apeach = 0;
            lion = 0;
            calculate(info);
            if (max < lion - apeach) {
                max = lion - apeach;
                System.arraycopy(tmp, 0, answer, 0, 11);
            } else if (max == lion - apeach) {
                check();
            }
            return;
        }

        for (int i = idx; i <= 10; i++) {
            tmp[i]++;
            dfs(i, n, info, cnt + 1);
            tmp[i]--;
        }
    }

    static void check() {
        for (int i = 10; i >= 0; i--) {
            if (tmp[i] > answer[i]) {
                System.arraycopy(tmp, 0, answer, 0, 11);
                return;
            } else if (tmp[i] < answer[i]) {
                return;
            }
        }
    }

    static void calculate(int[] info) {
        for (int i = 0; i <= 10; i++) {
            if (info[i] != 0 && info[i] >= tmp[i]) {
                apeach += (10 - i);
            } else if (info[i] < tmp[i]) {
                lion += (10 - i);
            }
        }
    }
}