import java.util.Stack;

class Solution {
    static class Home {
        int idx;
        int items;

        public Home(int idx, int items) {
            this.idx = idx;
            this.items = items;
        }
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Home> deliveryStack = new Stack<>();
        Stack<Home> pickupStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) deliveryStack.add(new Home(i, deliveries[i]));
            if (pickups[i] != 0) pickupStack.add(new Home(i, pickups[i]));
        }

        while (!(deliveryStack.isEmpty() && pickupStack.isEmpty())) {
            long len;
            if (deliveryStack.isEmpty() && !pickupStack.isEmpty()) {
                len = pickupStack.peek().idx;
            } else if (!deliveryStack.isEmpty() && pickupStack.isEmpty()) {
                len = deliveryStack.peek().idx;
            } else {
                len = Math.max(deliveryStack.peek().idx, pickupStack.peek().idx);
            }

            int truck = cap;
            while (truck > 0 && !deliveryStack.isEmpty()) {
                Home home = deliveryStack.pop();
                int delivery = home.items;
                int idx = home.idx;
                while (delivery > 0 && truck > 0) {
                    delivery--;
                    truck--;
                }
                if (delivery != 0) {
                    deliveryStack.add(new Home(idx, delivery));
                }
            }
            truck = cap;
            while (truck > 0 && !pickupStack.isEmpty()) {
                Home home = pickupStack.pop();
                int pickup = home.items;
                int idx = home.idx;
                while (pickup > 0 && truck > 0) {
                    pickup--;
                    truck--;
                }
                if (pickup != 0) {
                    pickupStack.add(new Home(idx, pickup));
                }
            }
            answer += ((len + 1) * 2);
        }

        return answer;
    }
}