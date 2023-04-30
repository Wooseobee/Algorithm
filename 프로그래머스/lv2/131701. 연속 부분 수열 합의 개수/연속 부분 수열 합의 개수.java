import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> ans = new HashSet<>();
        int n = elements.length;
        
        for(int i=1;i<=elements.length;i++){
            for(int j=0;j<=elements.length;j++){
                int sum = 0;
                for(int k=j;k<j+i;k++){
                    sum += elements[k%n];
                }
                ans.add(sum);
            }
        }
        
        return ans.size();
    }
}