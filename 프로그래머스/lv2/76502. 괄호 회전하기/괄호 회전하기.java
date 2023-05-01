import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        Deque<Character> deque = new ArrayDeque<>();

        for(int i=0;i<len;i++){
            deque.add(s.charAt(i));
        }

        for(int i=0;i<len;i++){
            deque.addLast(deque.removeFirst());
            Deque<Character> tmp = new ArrayDeque<>(deque);
            if(check(deque)) answer++;
            deque = tmp;
        }

        return answer;
    }

    private static boolean check(Deque<Character> deque){
        Stack<Character> stack = new Stack<>();

        while(!deque.isEmpty()){
            if(stack.isEmpty()) stack.push(deque.removeFirst());
            else {
                char top = stack.peek();
                char first = deque.removeFirst();
                switch(first){
                    case '[':
                    case '{':
                    case '(':
                        stack.push(first);
                        break;
                    case ']':
                        if(top!='[') return false;
                        stack.pop();
                        break;
                    case '}':
                        if(top!='{') return false;
                        stack.pop();
                        break;
                    case ')':
                        if(top!='(') return false;
                        stack.pop();
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}