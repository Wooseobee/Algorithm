import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[] s, e;
    private static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    private static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    private static boolean[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        s = new int[2];
        e = new int[2];
        
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
            n = Integer.parseInt(br.readLine());
            map = new boolean[n][n];
            
            String[] in = br.readLine().split(" ");
            s[0] = Integer.parseInt(in[0]);
            s[1] = Integer.parseInt(in[1]);
            
            in = br.readLine().split(" ");
            e[0] = Integer.parseInt(in[0]);
            e[1] = Integer.parseInt(in[1]);
            
            sb.append(bfs()).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
    private static int bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        q.add(new int[]{s[0], s[1], 0});
        map[s[0]][s[1]] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            int cnt = now[2];
            
            if(i == e[0] && j == e[1]) return cnt;
            
            for(int k = 0;k < 8;k++) {
                int nI = i + dx[k];
                int nJ = j + dy[k];
                if(in(nI, nJ) && !map[nI][nJ]) {
                    q.add(new int[] {nI, nJ, cnt + 1});
                    map[nI][nJ] = true;
                }
            }
        }
        return 0;
    }
    
    private static boolean in(int i, int j) {
        return i>=0 && j>=0 && i<n && j<n;
    }
}