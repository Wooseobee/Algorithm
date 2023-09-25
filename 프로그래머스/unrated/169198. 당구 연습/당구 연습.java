class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int sX = startX;
        int sY = startY;
        for(int i = 0; i < balls.length;i++) {
            int x = balls[i][0];
            int y = balls[i][1];
            int min = Integer.MAX_VALUE;
            double x1, y1;
            
            //왼쪽 벽
            if(sY != y || (sY == y && sX < x)) {
                x1 = sX *(-1);
                y1 = sY;
                int total = (int) (Math.pow(Math.abs(x - x1), 2) + Math.pow(Math.abs(y-y1),2));
                min = Math.min(min, total);
            }
            
            //오른쪽 벽
            if(sY != y || (sY == y && sX > x)) {
                x1 = sX + ((m - sX) * 2);
                y1 = sY;
                int total = (int) (Math.pow(Math.abs(x - x1), 2) + Math.pow(Math.abs(y-y1),2));
                min = Math.min(min, total);
            }
            
            //위쪽 벽
            if(sX != x || (sX == x && sY < y)) {
                x1 = sX;
                y1 = sY *(-1);
                int total = (int) (Math.pow(Math.abs(x - x1), 2) + Math.pow(Math.abs(y-y1),2));
                min = Math.min(min, total);
            }
            
            //아래쪽 벽
            if(sX != x || (sX == x && sY > y)) {
                x1 = sX;
                y1 = sY + ((n - sY) * 2);
                int total = (int) (Math.pow(Math.abs(x - x1), 2) + Math.pow(Math.abs(y-y1),2));
                min = Math.min(min, total);
            }
            
            answer[i] = min;
        }
        return answer;
    }
}