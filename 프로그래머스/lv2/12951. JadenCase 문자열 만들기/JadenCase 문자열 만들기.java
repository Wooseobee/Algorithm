class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strings = s.toLowerCase().split("");
        boolean changeWord = true;
        for(String str : strings){            
            answer+=changeWord ? str.toUpperCase():str;
            changeWord = str.equals(" ") ? true:false;
        }
        return answer;
    }
}