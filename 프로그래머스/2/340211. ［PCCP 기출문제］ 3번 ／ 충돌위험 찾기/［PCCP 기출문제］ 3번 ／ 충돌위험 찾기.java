import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int n = points.length;
        int x = routes.length; // 로봇 수
        int[][] map = new int[101][101]; 

        // 포인트 번호 -> (r, c) 매핑
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pointMap.put(i + 1, new int[] { points[i][0], points[i][1] });
        }

        // 로봇 상태 초기화
        int[][] robotNow = new int[x][2];
        int[] nextTarget = new int[x];
        boolean[] finished = new boolean[x];

        // 모든 로봇의 시작 위치 설정
        for (int i = 0; i < x; i++) {
            int[] start = pointMap.get(routes[i][0]);
            robotNow[i][0] = start[0];
            robotNow[i][1] = start[1];
            nextTarget[i] = 1;
            map[start[0]][start[1]]++;
        }

        int activeRobots = x;
        int answer = 0;

        answer += countCollisions(map, robotNow, finished);

        while (activeRobots > 0) {
            for (int i = 0; i < x; i++) {
                if (finished[i]) continue;

                int[] target = pointMap.get(routes[i][nextTarget[i]]);

                if (robotNow[i][0] == target[0] && robotNow[i][1] == target[1]) {
                    continue;
                }

                map[robotNow[i][0]][robotNow[i][1]]--;

                if (robotNow[i][0] > target[0]) {
                    robotNow[i][0]--;
                } else if (robotNow[i][0] < target[0]) {
                    robotNow[i][0]++;
                } else if (robotNow[i][1] > target[1]) {
                    robotNow[i][1]--;
                } else if (robotNow[i][1] < target[1]) {
                    robotNow[i][1]++;
                }

                map[robotNow[i][0]][robotNow[i][1]]++;

                if (robotNow[i][0] == target[0] && robotNow[i][1] == target[1]) {
                    if (nextTarget[i] < routes[i].length - 1) {
                        nextTarget[i]++;
                    } else {
                        finished[i] = true;
                    }
                }
            }

            answer += countCollisions(map, robotNow, finished);

            for (int i = 0; i < x; i++) {
                if (finished[i]) {
                    int r = robotNow[i][0];
                    int c = robotNow[i][1];
                    if (map[r][c] > 0) {
                        map[r][c]--;
                    }
                    finished[i] = false;
                    activeRobots--;
                }
            }
        }

        return answer;
    }

    private int countCollisions(int[][] map, int[][] robotNow, boolean[] finished) {
        int count = 0;
        for (int r = 0; r < 101; r++) {
            for (int c = 0; c < 101; c++) {
                if (map[r][c] > 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
