import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int n = board.length;
        int m = board[0].length;
        int[] top = new int[m];
        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n; i++) {
                if(board[i][j] != 0) {
                    top[j] = i;
                    break;
                }
            }
        }
        
        for(int move : moves) {
            int j = move - 1;
            if(top[j] != n) {
                int idx = top[j];
                int num = board[idx][j];
                if(!stack.isEmpty()) {
                    int before = stack.peek();
                    if(before == num) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(num);
                    }
                } else {
                    stack.push(num);
                }
                top[j]++;
            }
        }
        return answer;
    }
}