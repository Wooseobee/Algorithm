class Solution {
    public int solution(int a, int b) {
        return a % 2 == 1 ? (b % 2 == 1 ? (int) (Math.pow(a, 2) + Math.pow(b, 2)) : (2 * (a + b))) : (b % 2 == 1 ? (2 * (a + b)) : (Math.abs(a - b)));
    }
}