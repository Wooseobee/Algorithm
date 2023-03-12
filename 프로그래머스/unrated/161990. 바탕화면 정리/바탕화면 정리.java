class Solution {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        String[][] map = new String[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = String.valueOf(wallpaper[i].charAt(j));
            }
        }
        
        int minY = 50;
        int minX = 50;
        int maxX = 0;
        int maxY = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j].equals("#")){
                    minY=Math.min(minY, i);
                    minX=Math.min(minX, j);
                    maxY=Math.max(maxY, i);
                    maxX=Math.max(maxX, j);
                }
            }
        }
        
        return new int[]{minY,minX,maxY+1,maxX+1};
    }
}