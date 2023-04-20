import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char now = s.charAt(i);
            if(stack.isEmpty()) stack.push(now);
            else {
                char top = stack.peek();
                if(top==now) stack.pop();
                else stack.push(now);
            }
        }
        
        return stack.size()==0?1:0;
    }
}