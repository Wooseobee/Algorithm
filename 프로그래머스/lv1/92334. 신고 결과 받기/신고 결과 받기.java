import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> reportedNum = new TreeMap<>();
        Map<String, Set<String>> map = new HashMap<>();
        
        for(int i=0;i<id_list.length;i++){
            map.put(id_list[i],new HashSet<>());
            reportedNum.put(id_list[i], 0);
        }
        
        for(int i=0;i<report.length;i++){
            String[] rep = report[i].split(" ");
            String id1 = rep[0];
            String id2 = rep[1];
            if(!map.get(id1).contains(id2)){
                reportedNum.put(id2,reportedNum.get(id2)+1);
                map.get(id1).add(id2);
            }
        }
        
        Set set = reportedNum.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry) it.next();
            String id = (String) entry.getKey();
            int reported = (Integer) entry.getValue();
            if(reported>=k){
                for(int i=0;i<id_list.length;i++){
                    String s = id_list[i];
                    if(map.get(s).contains(id)){
                        answer[i]++;
                    }
                }
            }
        }
        
        return answer;
    }
}