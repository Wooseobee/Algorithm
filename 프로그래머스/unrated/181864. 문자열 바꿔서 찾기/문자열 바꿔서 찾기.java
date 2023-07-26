class Solution {
    public int solution(String myString, String pat) {
        return myString.replace("A", "*").replace("B", "+").replace("*", "B").replace("+", "A").contains(pat) ? 1 : 0;
    }
}