import java.util.*;

class Solution {
    private int[] dx = {-1,0,0,1};
    private int[] dy = {0,-1,1,0};
    
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int[] answer = new int[2];
        int max = 0;
        int cnt = 0;
        
        for(int i = 0 ; i < m ; i ++ ) {
            for(int j = 0 ; j < n; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    cnt++;
                    max = Math.max(max, bfs(m, n, visited, answer, i, j, picture));
                }
            }
        }
        answer[0] = cnt;
        answer[1] = max;
        return answer;
    }
    
    public int bfs(int m, int n, boolean[][] visited, int[] answer, int i, int j, int[][] picture) {
        Queue<int[]> q = new LinkedList<>();
        int color = picture[i][j];
        
        q.add(new int[]{i,j,1});
        visited[i][j] = true;
        int cnt = 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            cnt++;
            
            for(int k = 0; k<4;k++) {
                int nI = now[0] + dx[k];
                int nJ = now[1] + dy[k];
                if(nI>=0 && nJ>=0 && nI<m && nJ < n && picture[nI][nJ] == color && !visited[nI][nJ]) {
                    visited[nI][nJ] = true;
                    q.add(new int[]{nI,nJ});
                }
            }
        }
        return cnt;
    }
}