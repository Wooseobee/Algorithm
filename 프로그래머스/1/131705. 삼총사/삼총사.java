class Solution {
    int[] bro = new int[3];
    boolean[] visited;
    int answer = 0;
    int len;
    
    public int solution(int[] number) {    
        len = number.length;
        visited = new boolean[len];
        
        backTracking(0, 0, number);
        return answer;
    }
    
    private void backTracking(int depth, int idx, int[] number) {
        if(depth == 3) {
            if(checkNum(number)) {
                answer++;
            }
            return;
        }
        for(int i = idx; i < len; i++) {
            if(!visited[i]) {
                visited[i] = true;
                bro[depth] = i;
                backTracking(depth + 1, i + 1, number);
                visited[i] = false;
            }
        }
    }
    
    private boolean checkNum(int[] number) {
        int total = 0;
        for(int i=0;i<3;i++) {
            total += number[bro[i]];
        }
        return total == 0;
    }
}