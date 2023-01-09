import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class onBridgeTruck {
        int weight;
        int onTime;

        public onBridgeTruck(int weight, int onTime) {
            this.weight = weight;
            this.onTime = onTime;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int trucks = truck_weights.length;

        Queue<Integer> stayTrucks = new LinkedList<>();
        Queue<onBridgeTruck> onBridge = new LinkedList<>();
        Queue<Integer> finishTruck = new LinkedList<>();

        for (int i = 0; i < trucks; i++) {
            stayTrucks.add(truck_weights[i]);
        }

        while (finishTruck.size() != trucks) {
            int now = 0;
            int next = 0;

            if (!stayTrucks.isEmpty()) {
                next = stayTrucks.peek();
            }

            for (Iterator<onBridgeTruck> it = onBridge.iterator(); it.hasNext(); ) {
                onBridgeTruck truck = it.next();
                now += truck.weight;
                truck.onTime++;
                if (truck.onTime == bridge_length) {
                    finishTruck.add(truck.weight);
                    now -= truck.weight;
                }
            }

            onBridge.removeIf(truck -> truck.onTime == bridge_length);

            if (now + next <= weight && !stayTrucks.isEmpty()) {
                onBridge.add(new onBridgeTruck(stayTrucks.poll(), 0));
            }
            answer++;
        }

        return answer;
    }
}