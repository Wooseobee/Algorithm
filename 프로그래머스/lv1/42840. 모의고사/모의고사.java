import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1,2,3,4,5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int aCnt = 0, bCnt = 0, cCnt = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i%a.length]) aCnt++;
            if (answers[i] == b[i%b.length]) bCnt++;
            if (answers[i] == c[i%c.length]) cCnt++;
        }

        List<Integer> list = new ArrayList<>();
        int max = Math.max(aCnt, Math.max(bCnt, cCnt));

        if (max == aCnt) list.add(1);
        if (max == bCnt) list.add(2);
        if (max == cCnt) list.add(3);

        System.out.println(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}