import java.util.PriorityQueue;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return Integer.parseInt(o2) - Integer.parseInt(o1);
            }
            return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
        });

        for (int number : numbers) {
            pq.add(String.valueOf(number));
        }

        while (!pq.isEmpty()) {
            answer.append(pq.poll());
        }

        if (answer.charAt(0) == '0') return "0";

        return answer.toString();
    }
}