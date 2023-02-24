class Solution {
    static int r=0,t=0,c=0,f=0,j=0,m=0,a=0,n=0;
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        for(int i=0;i<survey.length;i++){
            doSurvey(i,survey[i],choices[i]);
        }
        
        if(r==t) answer+="R";
        else answer += (r>t?"R":"T");
            
        if(c==f) answer+="C";
        else answer += (c>f?"C":"F");
            
        if(j==m) answer+="J";
        else answer += (j>m?"J":"M");
            
        if(a==n) answer+="A";
        else answer += (a>n?"A":"N");
        
        return answer;
    }
    public static void doSurvey(int i, String s, int choice){
        switch(s.charAt(0)){
            case 'R':
                if(choice<4) r+=(4-choice);
                else if(choice>4) t+=(choice-4);
                break;
            case 'T':
                if(choice<4) t+=(4-choice);
                else if(choice>4) r+=(choice-4);
                break;
            case 'C':
                if(choice<4) c+=(4-choice);
                else if(choice>4) f+=(choice-4);
                break;
            case 'F':
                if(choice<4) f+=(4-choice);
                else if(choice>4) c+=(choice-4);
                break;
            case 'J':
                if(choice<4) j+=(4-choice);
                else if(choice>4) m+=(choice-4);
                break;
            case 'M':
                if(choice<4) m+=(4-choice);
                else if(choice>4) j+=(choice-4);
                break;
            case 'A':
                if(choice<4) a+=(4-choice);
                else if(choice>4) n+=(choice-4);
                break;
            case 'N':
                if(choice<4) n+=(4-choice);
                else if(choice>4) a+=(choice-4);
                break;
        }
    }
}