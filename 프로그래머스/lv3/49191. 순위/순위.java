import java.util.*;
class Solution {
    // 부모 or 자식의 총합 = n 인 경우 answer++
    class Player {
        List<Integer> parent;
        List<Integer> child;
        
        public Player() {
        	parent = new ArrayList<>();
        	child = new ArrayList<>();
        }
        
        public List<Integer> getParentList() {
            return parent;
        }
        
        public List<Integer> getChildList() {
            return child;
        }
    }
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        Player[] players = new Player[n + 1];
        
        for (int i = 0; i <= n; i++) {
			players[i] = new Player();
		}
        
        for(int[] result : results) {
            int p1 = result[0];
            int p2 = result[1];
            
            players[p1].getChildList().add(p2);
            players[p2].getParentList().add(p1);
        }
        
        for(int i = 1 ; i<=n ; i++) {
            if(countParentAndChild(players, i, n) == n - 1) answer++;
        }
        
        return answer;
    }
    
    private int countParentAndChild(Player[] players, int i, int n) {
        boolean[] visited = new boolean[n + 1];
        Set<Integer> parents = countParent(players, new HashSet<>(), i, visited);
        Set<Integer> childs = countChild(players, new HashSet<>(), i, visited);
        
        return parents.size() - 1 + childs.size() - 1;
    }
    
    private Set<Integer> countParent(Player[] players, Set<Integer> parents, int idx, boolean[] visited){
        visited[idx] = true;
        parents.add(idx);
        if(players[idx].getParentList().size() == 0) {
            return parents;
        }
        for(int i : players[idx].getParentList()) {
            if(!visited[i]){
                countParent(players, parents, i, visited);
            }
        }
        return parents;
    }
    
    private Set<Integer> countChild(Player[] players, Set<Integer> childs, int idx, boolean[] visited){
        visited[idx] = true;
        childs.add(idx);
        if(players[idx].getChildList().size() == 0) {
            return childs;
        }
        for(int i : players[idx].getChildList()) {
            if(!visited[i]){
                countChild(players, childs, i, visited);
            }
        }
        return childs;
    }
}