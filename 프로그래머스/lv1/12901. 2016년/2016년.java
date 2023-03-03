class Solution {
    static final String[] day = new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};

    public String solution(int a, int b) {
        String[][] date = new String[13][32];
        int idx = 5;

        for(int i=1;i<=12;i++){
            int limit = 0;
            switch (i){
                case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                    limit=31;
                    break;
                case 2:
                    limit=29;
                    break;
                case 4:case 6:case 9:case 11:
                    limit=30;
                    break;
            }
            for(int j=1;j<=limit;j++){
                if(idx>6){
                    idx = 0;
                }
                date[i][j] = day[idx++];
            }
        }
        return date[a][b];
    }
}