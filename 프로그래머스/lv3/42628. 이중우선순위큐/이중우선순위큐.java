import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Stack<Integer> stack = new Stack<>();

        for (String str : operations) {
            String op = str.split(" ")[0];
            int num = Integer.parseInt(str.split(" ")[1]);

            switch (op) {
                case "I":
                    pq.add(num);
                    break;
                case "D":
                    if (pq.isEmpty()) break;
                    if (num == -1) {
                        pq.poll();
                    } else {
                        while (pq.size() != 1) {
                            stack.add(pq.poll());
                        }
                        pq.poll();
                        while (!stack.isEmpty()) {
                            pq.add(stack.pop());
                        }
                    }
            }
        }

        if (pq.size() == 1) {
            answer[0] = answer[1] = pq.poll();
        } else if (pq.size()>=2){
            answer[1] = pq.poll();
            while (!pq.isEmpty()) {
                answer[0] = pq.poll();
            }
        }
        return answer;
    }
}