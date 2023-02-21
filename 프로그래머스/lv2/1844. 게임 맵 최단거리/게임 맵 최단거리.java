import java.util.*;

class Solution {
    static int[] di = new int[]{-1,1,0,0};
    static int[] dj = new int[]{0,0,-1,1};
    
    public int solution(int[][] maps) {
        
        return bfs(maps);
    }
    
    static class Point{
        int i;
        int j;
        int cnt;
        public Point(int i, int j, int cnt){
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
    
    static int bfs(int[][] maps){
        Queue<Point> q = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        q.add(new Point(0,0,1));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(p.i==n-1&&p.j==m-1) return p.cnt;
            
            for(int k=0;k<4;k++){
                int i = p.i + di[k];
                int j = p.j + dj[k];
                int cnt = p.cnt + 1;
                if(i>=0 && j>=0 && i<n && j<m){
                    if(!visited[i][j] && maps[i][j]==1){
                        visited[i][j] = true;
                        q.add(new Point(i,j,cnt));
                    }
                }
            }
        }
        
        return -1;
    }
}