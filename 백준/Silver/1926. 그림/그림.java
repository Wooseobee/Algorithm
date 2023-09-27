import java.util.*;
import java.io.*;

public class Main {
    
    private static int n,m;
    private static final int[] dx = {-1,0,0,1};
    private static final int[] dy = {0,-1,1,0};
    private static boolean[][] visited;
    private static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0;i<n;i++) {
            in = br.readLine().split(" ");
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(in[j]);
            }
        }
        
        int max = 0, cnt = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(i, j));
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt + "\n" + max);
		br.close();
	}
    
    private static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        int cnt = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowI = now[0];
            int nowJ = now[1];
            
            for(int k=0;k<4;k++) {
                int nI = nowI + dx[k];
                int nJ = nowJ + dy[k];
                if(in(nI,nJ) && !visited[nI][nJ] && map[nI][nJ] == 1) {
                    q.add(new int[]{nI,nJ});
                    visited[nI][nJ] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    private static boolean in(int i, int j) {
        return i>=0 && j>=0 && i<n && j<m;
    }
}