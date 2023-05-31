import java.util.*;

class Solution {
    class Pick {
        int pick;
        int dia;
        int iron;
        int stone;
        int pirodo;
        int idx;

        public Pick(int pick, int dia, int iron, int stone, int pirodo, int idx) {
            this.pick = pick;
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
            this.pirodo = pirodo;
            this.idx = idx;
        }
    }

    Queue<Pick> q = new LinkedList<>();

    public int solution(int[] picks, String[] minerals) {
        int answer = Integer.MAX_VALUE;

        if (picks[0] != 0) q.add(new Pick(0, picks[0], picks[1], picks[2], 0, 0));
        if (picks[1] != 0) q.add(new Pick(1, picks[0], picks[1], picks[2], 0, 0));
        if (picks[2] != 0) q.add(new Pick(2, picks[0], picks[1], picks[2], 0, 0));
        while (!q.isEmpty()) {
            Pick now = q.poll();
            int pick = now.pick;
            int dia = now.dia;
            int iron = now.iron;
            int stone = now.stone;
            int idx = now.idx;
            int pirodo = now.pirodo + work(pick, idx, minerals);

            if (pick == 0) dia--;
            else if (pick == 1) iron--;
            else stone--;

            if (idx + 5 < minerals.length) {
                if (dia != 0) q.add(new Pick(0, dia, iron, stone, pirodo, idx + 5));
                if (iron != 0) q.add(new Pick(1, dia, iron, stone, pirodo, idx + 5));
                if (stone != 0) q.add(new Pick(2, dia, iron, stone, pirodo, idx + 5));
            } else {
                answer = Math.min(answer, pirodo);
            }
            if (dia == 0 && iron == 0 && stone == 0) answer = Math.min(answer, pirodo);
        }

        return answer;
    }

    private int work(int kind, int idx, String[] minerals) {
        int pirodo = 0;
        switch (kind) {
            case 0:
                for (int i = idx; i < minerals.length && i < idx + 5; i++) {
                    pirodo++;
                }
                break;
            case 1:
                for (int i = idx; i < minerals.length && i < idx + 5; i++) {
                    if (minerals[i].equals("diamond")) pirodo += 5;
                    else pirodo++;
                }
                break;
            default:
                for (int i = idx; i < minerals.length && i < idx + 5; i++) {
                    if (minerals[i].equals("diamond")) pirodo += 25;
                    else if (minerals[i].equals("iron")) pirodo += 5;
                    else pirodo++;
                }
                break;
        }
        return pirodo;
    }
}