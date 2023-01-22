import java.util.Stack;

class Solution {
    static class stock {
        int idx;
        int price;

        public stock(int idx, int price) {
            this.idx = idx;
            this.price = price;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<stock> s = new Stack<>();
        int duration = prices.length;

        s.add(new stock(0, prices[0]));

        for (int i = 1; i < duration; i++) {
            while (!s.isEmpty()) {
                stock stock = s.peek();
                int price = stock.price;
                int now = stock.idx;

                if (price > prices[i]) {
                    answer[now] = i - now;
                    s.pop();
                } else {
                    break;
                }
            }
            s.add(new stock(i, prices[i]));
        }

        while (!s.isEmpty()) {
            stock stock = s.pop();
            int now = stock.idx;

            answer[now] = duration - 1 - now;
        }

        return answer;
    }
}