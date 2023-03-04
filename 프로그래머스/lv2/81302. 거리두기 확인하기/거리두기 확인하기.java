import java.util.*;

class Solution {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0;i<5;i++){
            String[][] room = new String[5][5];
            boolean[][] visited = new boolean[5][5];
            for(int j=0;j<5;j++){
                String[] line = places[i][j].split("");
                for(int k=0;k<5;k++){
                    room[j][k]=line[k];
                }
            }
            if(checkRoom(room, visited)){
                answer[i]=1;    
            }
        }
        
        return answer;
    }
    static boolean checkRoom(String[][] room, boolean[][] visited){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(room[i][j].equals("P")){
                    if(!checkDist(i,j, room, visited)) return false;
                    for(int k=0;k<5;k++){
                        Arrays.fill(visited[k], false);
                    }
                }
            }
        }
        return true;
    }
    
    static boolean checkDist(int i, int j, String[][] room, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j,0});
        visited[i][j] = true;
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            
            if(!(p[0]==i&&p[1]==j) && room[p[0]][p[1]].equals("P")){
                if(p[2]<=2){
                    return false;
                }
            }
            
            for(int k=0;k<4;k++){
                int newI = p[0]+di[k];
                int newJ = p[1]+dj[k];
                if(newI>=0&&newJ>=0&&newI<5&&newJ<5){
                    if(!visited[newI][newJ] && !(room[newI][newJ].equals("X"))){
                        q.add(new int[]{newI,newJ,p[2]+1});
                        visited[newI][newJ] = true;
                    }
                }
            }
        }
        return true;
    }
}