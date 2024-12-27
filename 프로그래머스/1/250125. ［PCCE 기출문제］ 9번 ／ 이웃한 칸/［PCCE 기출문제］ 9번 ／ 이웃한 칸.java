class Solution {
    int[] dx = new int[]{-1,0,0,1};
    int[] dy = new int[]{0,-1,1,0};
    int n, m;
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        n = board.length;
        m = board[0].length;
        
        for(int i = 0; i < 4; i++) {
            int nI = h + dx[i];
            int nJ = w + dy[i];
            if(isIn(nI, nJ)) {
                if(board[nI][nJ].equals(board[h][w])) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private boolean isIn(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}