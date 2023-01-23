import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = new int[answers.length];
        int[] b = new int[answers.length];
        int[] c = new int[answers.length];
        int aCnt = 0, bCnt = 0, cCnt = 0;

        for (int i = 0; i < answers.length; i++) {
            switch (i % 5) {
                case 0: a[i] = 1; break;
                case 1: a[i] = 2; break;
                case 2: a[i] = 3; break;
                case 3: a[i] = 4; break;
                default: a[i] = 5; break;
            }
        }
        for (int i = 0; i < answers.length; i++) {
            switch (i % 8) {
                case 0:
                case 2:
                case 4:
                case 6:
                    b[i] = 2; break;
                case 1: b[i] = 1; break;
                case 3: b[i] = 3; break;
                case 5: b[i] = 4; break;
                default: b[i] = 5; break;
            }
        }
        for (int i = 0; i < answers.length; i++) {
            switch (i % 10) {
                case 0:
                case 1:
                    c[i] = 3; break;
                case 2:
                case 3:
                    c[i] = 1; break;
                case 4:
                case 5:
                    c[i] = 2; break;
                case 6:
                case 7:
                    c[i] = 4; break;
                default: c[i] = 5; break;
            }
        }

        for (int i = 0; i < answers.length; i++) {
            if (a[i] == answers[i]) aCnt++;
            if (b[i] == answers[i]) bCnt++;
            if (c[i] == answers[i]) cCnt++;
        }
        if (aCnt == bCnt && bCnt == cCnt) {
            return new int[]{1, 2, 3};
        }

        List<Integer> list = new ArrayList<>();
        int max = Math.max(aCnt, Math.max(bCnt, cCnt));

        if (max==aCnt) list.add(1);
        if (max==bCnt) list.add(2);
        if (max==cCnt) list.add(3);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}