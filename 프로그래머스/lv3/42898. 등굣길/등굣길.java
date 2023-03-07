class Solution {
    static int[][] map;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[n+1][m+1];
        
        for(int i=0;i<puddles.length;i++){
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        return dfs(1,1,n,m);
    }
    static int dfs(int i,int j, int n, int m){
        if(i==n&&j==m){
            return 1;
        }
        
        if(map[i][j]!=0) return map[i][j];
        
        if(i+1<=n && map[i+1][j]!=-1){
            map[i][j] += dfs(i+1,j,n,m);
            if(map[i][j]>1_000_000_007) map[i][j] %= 1_000_000_007;
        }
        if(j+1<=m &&map[i][j+1]!=-1){
            map[i][j] += dfs(i,j+1,n,m);
            if(map[i][j]>1_000_000_007) map[i][j] %= 1_000_000_007;
        }
        
        return map[i][j];
    }
}