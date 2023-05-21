class Solution {
    public int solution(int[] num_list) {
        int multiple = 1;
        int plus = 0;
        for (int num : num_list) {
            multiple *= num;
            plus += num;
        }
        return multiple > Math.pow(plus, 2) ? 0 : 1;
    }
}