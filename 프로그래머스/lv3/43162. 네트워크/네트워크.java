class Solution {
    static int answer = 1, cnt;
    static int[] visited;
    public int solution(int n, int[][] computers) {
        visited = new int[n];
        
        for(int i=0;i<n;i++){
            cnt = 0;
            if(visited[i]==0){
                dfs(n,computers,i);
            }
            if(cnt>0) answer++;
        }
        return answer-1;
    }
    public void dfs(int n, int[][] computers, int v){
        for(int j =0;j<n;j++){
            if(visited[j]==0 && computers[v][j]==1){
                visited[j]=answer;
                dfs(n,computers,j);
                cnt++;
            }
        }
    }
}