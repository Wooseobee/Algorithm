import java.util.*;

class Solution {
    static void dfs(int depth){
        if(depth==4){
            String s = String.join("",comb);
            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(score);
        }else {
            comb[depth] = infos[depth];
            dfs(depth+1);
            comb[depth] = "-";
            dfs(depth+1);
        }
    }
    
    static String[] infos;
    static String[] comb;
    static int score;
    static Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(String str :info){
            comb = new String[4];
            infos = str.split(" ");
            score = Integer.parseInt(infos[4]);
            dfs(0);
        }
        
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        
        int idx = 0;    
        for(String q : query){
            String[] strs = q.split(" and | ");
            String key = strs[0]+strs[1]+strs[2]+strs[3];
            
            if(!map.containsKey(key)){
                answer[idx++]=0;
            }
            else {
                List<Integer> ansList = map.get(key);
                answer[idx++] = ansList.size() - lowerBound(ansList, Integer.parseInt(strs[4]));
            }
        }
        
        return answer;
    }
    
    static int lowerBound(List<Integer> list, int score){
        int l = 0;
        int r = list.size()-1;
        while(l<=r){
            int mid = (l+r)/2;
            
            if(list.get(mid)<score){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        
        return l;
    }
}