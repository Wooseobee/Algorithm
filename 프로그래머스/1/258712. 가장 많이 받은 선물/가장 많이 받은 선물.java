import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        
        Map<String, Map<String, Integer>> map = new HashMap<>();
        Map<String, Integer> score = new HashMap<>();
        
        for(String friend : friends) {
            map.put(friend, new HashMap<>());
            score.put(friend, 0);
        }
        
        for(String gift : gifts) {
            String[] f = gift.split(" ");
            String a = f[0];
            String b = f[1];
            
            Map<String, Integer> friend = map.get(a);
            friend.put(b, friend.getOrDefault(b, 0) + 1);
            
            score.put(a, score.get(a) + 1);
            score.put(b, score.get(b) - 1);
        }
        
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            String a = friends[i];
            Map<String, Integer> friend = map.get(a);
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                
                String b = friends[j];
                int aTob = friend.getOrDefault(b, 0);
                
                Map<String, Integer> friend2 = map.get(b);
                int bToa = friend2.getOrDefault(a, 0);
                
                if(aTob == 0 && bToa == 0 || aTob == bToa) {
                    int aScore = score.get(a);
                    int bScore = score.get(b);
                    if(aScore > bScore) {
                        cnt++;
                    }
                } else {
                    if(aTob > bToa) {
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}