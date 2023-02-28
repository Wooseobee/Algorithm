class Solution {
    public int solution(String s) {
        int answer = s.length();
        int len = s.length();

        for (int i = 1; i <= len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j += i) {
                int cnt = 1;
                if (j+i>len){
                    sb.append(s.substring(j, len));
                    break;
                }
                String str = s.substring(j, j + i);
                j += i;
                while (j + i <= len && str.equals(s.substring(j, j + i))) {
                    cnt++;
                    j += i;
                }
                if (cnt > 1) {
                    sb.append(cnt).append(str);
                } else {
                    sb.append(str);
                }
                j -= i;
            }
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}