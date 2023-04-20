import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> word = new HashSet<>();
        char prev = words[0].charAt(words[0].length()-1);
        word.add(words[0]);
        
        for(int i=1;i<words.length;i++){
            if(word.contains(words[i])){
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                break;
            }
            char firstCharacter = words[i].charAt(0);
            if(prev!=firstCharacter){
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                break;
            }
            word.add(words[i]);
            prev = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}