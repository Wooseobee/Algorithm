import java.util.PriorityQueue;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return Integer.parseInt(o2) - Integer.parseInt(o1);
            }
            return Integer.parseInt(o2.concat(o1)) - Integer.parseInt(o1.concat(o2));
        });

        int zeroCnt = 0;
        for (int number : numbers) {
            pq.add(String.valueOf(number));
            if (number == 0) zeroCnt++;
        }

        while (!pq.isEmpty()) {
            answer = answer.concat(pq.poll());
        }

        if (zeroCnt == numbers.length) return "0";

        return answer;
    }
}