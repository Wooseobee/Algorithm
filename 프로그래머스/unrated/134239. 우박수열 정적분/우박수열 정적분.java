import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> areaList = setAreaList(k);

        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = areaList.size() + ranges[i][1] - 1;
            answer[i] = getArea(a, b, areaList);
        }
        return answer;
    }

    private double getArea(int a, int b, List<Integer> areaList) {
        if (a > b) return -1.0;
        double total = 0;
        for (int i = a; i < b; i++) total += (areaList.get(i) + areaList.get(i + 1)) / 2.0;
        return total;
    }

    private List<Integer> setAreaList(int k) {
        List<Integer> areaList = new ArrayList<>();
        while (k > 1) {
            areaList.add(k);
            if (k % 2 == 0) k /= 2;
            else k = (k * 3) + 1;
        }
        areaList.add(1);

        return areaList;
    }
}