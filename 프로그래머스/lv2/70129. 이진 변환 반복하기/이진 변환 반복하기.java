class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            int len = s.length();
            System.out.println("hi");
            s=s.replaceAll("0","");
            answer[1]+=len-s.length();
            answer[0]++;
            s=Integer.toBinaryString(s.length());
        }
        
        return answer;
    }
}