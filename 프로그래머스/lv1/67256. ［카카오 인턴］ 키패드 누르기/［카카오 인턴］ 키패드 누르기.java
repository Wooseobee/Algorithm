import java.util.*;

class Solution {
    private int[][] key = new int[4][3];
    private HashMap<Integer, int[]> map = new HashMap<>();
    private List<Integer> leftList = Arrays.asList(1,4,7);
    private List<Integer> rightList = Arrays.asList(3,6,9);
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};
        
        int num = 1;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3 ; j++) {
                map.put(num++, new int[]{i,j});
            }
        }
        map.put(0, new int[] {3, 1});
        
        for(int n : numbers) {
            if(leftList.contains(n)) {
                sb.append("L");
                int[] loc = map.get(n);
                left[0] = loc[0];
                left[1] = loc[1];
            } else if (rightList.contains(n)) {
                sb.append("R");
                int[] loc = map.get(n);
                right[0] = loc[0];
                right[1] = loc[1];
            } else {
                int[] loc = map.get(n);
                int dist1 = Math.abs(left[0] - loc[0]) + Math.abs(left[1] - loc[1]);
                int dist2 = Math.abs(right[0] - loc[0]) + Math.abs(right[1] - loc[1]);
                
                if(dist1 > dist2) {
                    sb.append("R");
                    right[0] = loc[0];
                    right[1] = loc[1];
                } else if(dist1 < dist2) {
                    sb.append("L");
                    left[0] = loc[0];
                    left[1] = loc[1];
                } else {
                    if(hand.equals("right")) {
                        sb.append("R");
                        right[0] = loc[0];
                        right[1] = loc[1];
                    } else {
                        sb.append("L");
                        left[0] = loc[0];
                        left[1] = loc[1];
                    }
                }
            }
        }
        return sb.toString();
    }
}