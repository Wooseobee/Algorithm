import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        if(!findTarget(target, words)){
            return 0;
        } else {
            answer = bfs(words,begin,target,visited);
        }
        return answer;
    }
    static boolean findTarget(String target, String[] words){
        for(String w : words){
            if(w.equals(target)) return true;
        }
        return false;
    }
    static class Word {
        String word;
        int cnt;
        public Word(String word,int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    static int bfs(String[] words, String begin, String target, boolean[] visited){
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word word = q.poll();
            String w = word.word;
            int cnt = word.cnt;
            
            if(w.equals(target)) return cnt;
            
            for (int i =0; i< words.length;i++){
                if(!visited[i] && checkWord(w,words[i])){
                    q.add(new Word(words[i],cnt+1));
                    visited[i]= true;
                }
            }
        }
        return 0;
    }
    static boolean checkWord(String w1, String w2){
        int cnt = 0;
        for(int i=0;i<w1.length();i++){
            if(w1.charAt(i)!=w2.charAt(i)) cnt++;
        }
        return cnt==1;
    }
}