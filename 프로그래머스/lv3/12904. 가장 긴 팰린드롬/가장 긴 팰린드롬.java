class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        for(int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, findPalindrome(s, i - 1, i + 1));
            answer = Math.max(answer, findPalindrome(s, i, i + 1));
        }

        return answer;
    }
    private int findPalindrome(String str, int s, int e) {
        while(s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)){
            s--;
            e++;
        }
        
        return e - s - 1;
    }
}