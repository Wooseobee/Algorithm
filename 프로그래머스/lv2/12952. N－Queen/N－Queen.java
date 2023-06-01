class Solution {
    int[] map;
    int answer = 0;

    public int solution(int n) {
        map = new int[n];
        backTracking(0, n);
        return answer;
    }

    private void backTracking(int depth, int n) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            map[depth] = i;
            if (checkMap(depth)) backTracking(depth + 1, n);
        }
    }

    private boolean checkMap(int depth) {
        for (int i = 0; i < depth; i++) {
            if (map[depth] == map[i]) return false;
            else if (Math.abs(depth - i) == Math.abs(map[depth] - map[i])) return false;
        }
        return true;
    }
}