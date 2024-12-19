class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLen = t.length();
        int pLen = p.length();
        long pInt = Long.parseLong(p);

        for (int i = 0; i <= tLen - pLen; i++) {
            long tInt = Long.parseLong(t.substring(i, i + pLen));
            if(tInt <= pInt) {
                answer++;
            }
        }
        return answer;
    }
}