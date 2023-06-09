class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        return s.replace("p", "").length() == s.replace("y", "").length();
    }
}