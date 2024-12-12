import java.util.*;

class Solution {
    int[] dx = {0, 1, 1};
    int[] dy = {1, 0, 1};
    
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int h = park.length;
        int w = park[0].length;
        int m = mats.length;
        
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(park[i][j].equals("-1")) {
                    for(int k = 0; k < m; k++) {
                        if(isIn(i + mats[k] - 1, j, w, h) && isIn(i, j + mats[k] - 1, w, h) && checkPark(mats[k], i, j, w, h, park)) {
                            answer = Math.max(answer, mats[k]);
                        }
                    }
                }
            }
        }
        return answer == 0 ? -1 : answer;
    }
    
    private boolean checkPark(int size, int sI, int sJ, int w, int h, String[][] park) {
        boolean[][] visited = new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sI, sJ});
        visited[sI][sJ] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            
            for(int k = 0; k < 3; k++) {
                int nI = i + dx[k];
                int nJ = j + dy[k];
                
                if(isIn(nI, nJ, w, h) && sI + size > nI && sJ + size > nJ && !visited[nI][nJ]) {
                    if(park[nI][nJ].equals("-1")){
                        visited[nI][nJ] = true;
                        q.add(new int[]{nI, nJ});
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean isIn(int i, int j, int w, int h) {
        return i < h && j < w;
    }
}