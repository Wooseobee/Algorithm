class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] video = video_len.split(":");
        String[] p = pos.split(":");
        String[] ops = op_start.split(":");
        String[] ope = op_end.split(":");
        int v_len = Integer.parseInt(video[0]) * 60 + Integer.parseInt(video[1]);
        int pos_len = Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
        int op_start_len = Integer.parseInt(ops[0]) * 60 + Integer.parseInt(ops[1]);
        int op_end_len = Integer.parseInt(ope[0]) * 60 + Integer.parseInt(ope[1]);
        
        for(String command : commands) {
            if(pos_len >= op_start_len && pos_len <= op_end_len) {
                pos_len = op_end_len;
            }
            if(command.equals("prev")) {
                pos_len -= 10;
            } else {
                pos_len += 10;
            }
            
            if(pos_len < 0) {
                pos_len = 0;
            } else if(pos_len > v_len) {
                pos_len = v_len;
            }
        }
        
        if(pos_len >= op_start_len && pos_len <= op_end_len) {
            pos_len = op_end_len;
        }
        
        int mm = pos_len / 60;
        if(mm < 10) {
            answer += "0";
        }
        answer += String.valueOf(pos_len / 60) + ":";
        
        int ss = pos_len % 60;
        if(ss < 10) {
            answer += "0";
        }
        answer += String.valueOf(pos_len % 60);
        
        return answer;
    }
}