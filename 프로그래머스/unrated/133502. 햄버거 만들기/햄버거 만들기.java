import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int e : ingredient){
            stack.add(e);
            int ptr = stack.size();
            if(ptr >= 4){
                if(stack.elementAt(ptr - 1) == 1 && stack.elementAt(ptr - 2) == 3 && stack.elementAt(ptr - 3) == 2 && stack.elementAt(ptr - 4) == 1){
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;
    }
}