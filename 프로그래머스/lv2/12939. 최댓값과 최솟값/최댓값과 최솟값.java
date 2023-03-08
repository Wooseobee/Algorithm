class Solution {
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, Integer.parseInt(nums[i]));
            min = Math.min(min, Integer.parseInt(nums[i]));
        }
        answer = min + " " + max;
        return answer;
    }
}