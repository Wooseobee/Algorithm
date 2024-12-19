class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLen = t.length();
        int pLen = p.length();
        long pInt = Long.parseLong(p);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pLen; i++) {
            char ch = t.charAt(i);
            sb.append(ch);
        }
        
        for (int i = 0; i < tLen - pLen + 1; i++) {
            long tInt = Long.parseLong(sb.toString());
            if (tInt <= pInt) {
                answer++;
            }
            if (i == tLen - pLen) {
                break;
            }
            sb.deleteCharAt(0);
            sb.append(t.charAt(i + pLen));
        }
        return answer;
    }
}