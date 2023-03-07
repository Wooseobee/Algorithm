import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (o1,o2)->o1[1]-o2[1]);
        
        int camera = routes[0][1];
        for(int i=1;i<routes.length;i++){
            int start = routes[i][0];
            int end = routes[i][1];
            if(start<=camera && end>=camera){
                continue;
            } else {
                answer++;
                camera=end;
            }
        }
        
        return answer;
    }
}