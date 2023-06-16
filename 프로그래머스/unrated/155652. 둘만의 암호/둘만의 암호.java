class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        alphabet = alphabet.replaceAll("[" + skip + "]", "");
        for(char ch : s.toCharArray()) {
            answer += alphabet.charAt((alphabet.indexOf(ch) + index) % alphabet.length());
        }
        return answer;
    }
}