class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strings = s.split("");
        boolean changeWord = true;
        for(int i=0;i<strings.length;i++){
            String str = strings[i];
            if(str.equals(" ")){
                changeWord = true;
            } else if(changeWord){
                str = str.toUpperCase();
                changeWord = false;
            } else if(Character.isDigit(str.charAt(0))){
                continue;
            } else {
                str = str.toLowerCase();
            }
            
            answer+=str;
        }
        return answer;
    }
}