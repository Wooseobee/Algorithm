class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        String[][] map = new String[n][n];
        
        for(int i=0;i<n;i++){
            String[] str1 = String.format("%0"+n+"d", Long.parseLong(Long.toBinaryString(arr1[i]|arr2[i]))).split("");
            for(int j=0;j<str1.length;j++){
                if(str1[j].equals("0")){
                    map[i][j] = " ";
                } else {
                    map[i][j] = "#";
                }
            }
        }
        
        for(int i=0;i<n;i++){
            String s = "";
            for(int j=0;j<n;j++){
                s+=map[i][j];
            }
            answer[i] = s;
        }
        
        return answer;
    }
}