import java.util.*;

class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<edge.length;i++){
            int v1 = edge[i][0];
            int v2 = edge[i][1];
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        
        return bfs(visited);
    }
    
    static class Node {
        int v;
        int cnt;
        public Node (int v, int cnt){
            this.v = v;
            this.cnt = cnt;
        }
    }
    
    public static int bfs(boolean[] visited){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,0));
        visited[1] = true;
        
        int max = 0;
        int total = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            int v = node.v;
            int cnt = node.cnt;
            
            if(max<cnt){
                max = cnt;
                total = 1;
            } else if(max==cnt){
                total++;
            }
            
            for(int next : list.get(v)){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new Node(next,cnt+1));
                }
            }
        }
        return total;
    }
}