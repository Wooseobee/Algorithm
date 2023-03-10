import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Set<String> cache = new LinkedHashSet<>();

        for(String city : cities){
            city = city.toUpperCase();
            if(cacheSize!=0){
                if(cache.isEmpty()){
                    answer+=5;
                    cache.add(city);
                }else{
                    if(cache.contains(city)){
                        answer+=1;
                        resetCache(cache,city);
                    }else{
                        if(cache.size()==cacheSize){
                            removeLRU(cache);
                        }
                        answer+=5;
                        cache.add(city);
                    }
                }
            } else {
                answer+=5; 
            }
        }
        return answer;
    }
    static void removeLRU(Set<String> cache){
        for(String city : cache){
            cache.remove(city);
            break;
        }
    }
    static void resetCache(Set<String> cache, String city){
        cache.remove(city);
        cache.add(city);
    }
}