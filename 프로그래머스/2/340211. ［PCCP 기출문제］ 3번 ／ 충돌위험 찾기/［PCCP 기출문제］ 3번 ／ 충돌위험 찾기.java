import java.util.*;
import java.awt.Point;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<Integer, List<Point>> map = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            int level = 1;
            for (int j = 1; j < routes[i].length; j++) {
                int currentX = points[routes[i][j - 1] - 1][0];
                int currentY = points[routes[i][j - 1] - 1][1];
                int targetX = points[routes[i][j] - 1][0];
                int targetY = points[routes[i][j] - 1][1];

                while (currentX != targetX) {
                    List<Point> pList = map.getOrDefault(level, new ArrayList<>());
                    pList.add(new Point(currentX, currentY));
                    map.put(level++, pList);

                    if (currentX > targetX) 
                        currentX--;
                    else 
                        currentX++;
                }

                while (currentY != targetY) {
                    List<Point> pList = map.getOrDefault(level, new ArrayList<>());
                    pList.add(new Point(currentX, currentY));
                    map.put(level++, pList);

                    if (currentY > targetY) 
                        currentY--;
                    else 
                        currentY++;
                }
                if(j == routes[i].length -1){
                    List<Point> pList = map.getOrDefault(level, new ArrayList<>());
                    pList.add(new Point(currentX, currentY));
                    map.put(level, pList); 
                }
            }
        }

        for (Map.Entry<Integer, List<Point>> entry : map.entrySet()) {
            List<Point> list = entry.getValue();
            Map<Point, Integer> pmap = new HashMap<>();
            for (Point p : list) {
                pmap.put(p, pmap.getOrDefault(p, 0) + 1);
            }
            for (Map.Entry<Point, Integer> pentry : pmap.entrySet()) {
                if (pentry.getValue() > 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}