class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        for (int i = 0, j = 0, k = 0; i < goal.length; i++) {
            if (j < cards1.length && cards1[j].equals(goal[i])) {
                j++;
                continue;
            } else if (k < cards2.length && cards2[k].equals(goal[i])) {
                k++;
                continue;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}