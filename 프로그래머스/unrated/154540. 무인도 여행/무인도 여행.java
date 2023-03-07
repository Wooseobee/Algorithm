import java.util.*;

class Solution {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static boolean[][] visited;
    static String[][] map;
    static int n,m,cnt;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        map = new String[n][m];
        visited = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            String[] row = maps[i].split("");
            for(int j=0;j<m;j++){
                map[i][j] = row[j];
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && !map[i][j].equals("X")){
                    cnt = 0;
                    dfs(i,j);
                    pq.add(cnt);
                }
            }
        }
        if(pq.size()==0){
            return new int[]{-1};
        } else {
            int[] answer = new int[pq.size()];
            int idx=0;
            while(!pq.isEmpty()){
                answer[idx++]=pq.poll();
            }
            return answer;
        }
    }
    static void dfs(int i, int j){
        if(visited[i][j]) return;
        
        cnt+=Integer.parseInt(map[i][j]);
        visited[i][j] = true;
        for(int k=0;k<4;k++){
            int newI = i+di[k];
            int newJ = j+dj[k];
            if(newI>=0 && newJ>=0 && newI<n && newJ<m && !map[newI][newJ].equals("X")){
                dfs(newI,newJ);
            }
        }
    }
}