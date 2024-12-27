import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> rslt = new ArrayList<>();
        int idx = getIdx(ext);
        int sortIdx = getIdx(sort_by);
        
        for(int[] d : data) {
            if(d[idx] < val_ext) {
                rslt.add(d);
            }
        }
        
        Collections.sort(rslt, (o1, o2) -> o1[sortIdx] - o2[sortIdx]);
        return rslt.stream().toArray(int[][]::new);
    }
    
    private int getIdx(String data) {
        switch(data) {
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
            default:
                return -1;
        }
    }
}