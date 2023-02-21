import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {

        return dfs(0,0,numbers, target);
    }
    
    static int dfs(int n, int sum, int[] numbers, int target){
        if(n==numbers.length){
            if(sum==target) return 1;
            else return 0;
        }
        return dfs(n+1,sum+numbers[n], numbers, target) + dfs(n+1, sum-numbers[n], numbers,target);
    }
    
}