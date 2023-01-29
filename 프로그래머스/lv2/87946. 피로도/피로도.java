class Solution {
    static int len;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;

        visited = new boolean[len];

        dfs(k, 0, dungeons);

        return max;
    }

    static void dfs(int k, int size, int[][] dungeons) {
        if (k < 0) {
            return;
        } else {
            max = Math.max(max, size);
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], size + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}