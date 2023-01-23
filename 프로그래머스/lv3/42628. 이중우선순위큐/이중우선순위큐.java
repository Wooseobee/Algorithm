import java.util.*;

class Solution {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for (String str : operations) {
            String op = str.split(" ")[0];
            int num = Integer.parseInt(str.split(" ")[1]);

            switch (op) {
                case "I":
                    pq1.add(num);
                    pq2.add(num);
                    break;
                case "D":
                    if (!pq1.isEmpty() && !pq2.isEmpty()) {
                        if (num == -1) {
                            int min = pq1.poll();
                            pq2.remove(min);
                        } else {
                            int max = pq2.poll();
                            pq1.remove(max);
                        }
                    }
            }
        }

        if (pq1.size() > 0 && pq2.size() > 0) {
            answer[0] = pq2.poll();
            answer[1] = pq1.poll();
        }
        return answer;
    }
}