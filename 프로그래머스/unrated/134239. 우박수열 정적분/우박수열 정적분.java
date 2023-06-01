import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        double[] area = setArea(k);

        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = area.length + ranges[i][1];
            answer[i] = getArea(a, b, area);
        }
        return answer;
    }

    private double getArea(int a, int b, double[] area) {
        if (a > b) return -1.0;
        double total = 0;
        for (int i = a; i < b; i++) total += area[i];
        return total;
    }

    private double[] setArea(int k) {
        List<Integer> areaList = new ArrayList<>();
        while (k > 1) {
            areaList.add(k);
            if (k % 2 == 0) k /= 2;
            else k = (k * 3) + 1;
        }
        areaList.add(1);

        int len = areaList.size();
        double[] area = new double[len - 1];

        for (int i = 0; i < len - 1; i++) {
            double v = Math.min(areaList.get(i), areaList.get(i + 1)) + Math.abs(areaList.get(i) - areaList.get(i + 1)) / 2.0;
            v = v * 10 / 10;
            area[i] = v;
        }

        return area;
    }
}