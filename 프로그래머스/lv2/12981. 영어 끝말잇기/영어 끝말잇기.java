import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> word = new HashSet<>();
        char prev = words[0].charAt(words[0].length()-1);
        word.add(words[0]);
        
        for(int i=1;i<words.length;i++){
            word.add(words[i]);
            if(word.size()!=i+1){   // 중복 단어 확인
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                break;
            }
            char firstCharacter = words[i].charAt(0);
            if(prev!=firstCharacter){   // 끝말과 시작말 확인
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                break;
            }
            prev = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}