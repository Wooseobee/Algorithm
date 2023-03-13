import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<keymap.length;i++){
            for(int j=0;j<keymap[i].length();j++){
                char ch = keymap[i].charAt(j);
                if(!map.containsKey(ch)){
                    map.put(ch, j+1);
                }else{
                    if(map.get(ch)>j+1){
                        map.put(ch,j+1);
                    }
                }
            }
        }
        
        for(int i=0;i<targets.length;i++){
            int cnt = 0;
            int idx = 0;
            boolean canMake = true;
            for(int j=0;j<targets[i].length();j++){
                char ch = targets[i].charAt(j);
                if(map.get(ch)==null){
                    canMake = false;
                    break;
                }
                cnt+=map.get(ch);
            }
            if(canMake){
                answer[i]=cnt;
            }else{
                answer[i]=-1;
            }
        }
        
        return answer;
    }
}