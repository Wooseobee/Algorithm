import java.util.*;

class Solution {
    int answer = 0;
    boolean[] prime = new boolean[3_000];
    boolean[] visited;
    int[] choice = new int[3];
    Set<Integer> set = new HashSet<>();
    
    public int solution(int[] nums) {
        visited = new boolean[nums.length];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i <= Math.sqrt(3_000); i++) {
            for(int j = i * i; j < 3_000 ; j += i) {
                prime[j] = false;
            }
        }

        selectNum(0, 0, nums);

        return answer;
    }
    
    private void selectNum(int depth, int idx, int[] nums) {
        if(depth == 3) {
            int total = nums[choice[0]] + nums[choice[1]] + nums[choice[2]];
            if(isPrime(total)) {
                answer++;
            }
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                choice[depth] = i;
                selectNum(depth + 1, i + 1, nums);
                visited[i] = false;
            }
        }
    }
                
    private boolean isPrime(int total) {
        return prime[total];
    }
}