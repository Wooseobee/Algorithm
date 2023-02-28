import java.util.*;

class Solution {
    static class Game {
        int stage;
        double failRate;

        public Game(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int user = stages.length;
        int people = stages.length;
        int[] stageInfo = new int[N + 2];

        for (int stage : stages) {
            stageInfo[stage]++;
        }

        PriorityQueue<Game> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Game o1, Game o2) {
                if (o1.failRate == o2.failRate) {
                    return o1.stage - o2.stage;
                }
                return o2.failRate > o1.failRate ? 1 : -1;
            }
        });


        for (int i = 1; i < N + 1; i++) {
            if (people == 0 || stageInfo[i] == 0) pq.add(new Game(i, 0.0));
            else pq.add(new Game(i, stageInfo[i] * 100.0 / people));
            people -= stageInfo[i];
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            answer[idx++] = pq.poll().stage;
        }

        return answer;
    }
}