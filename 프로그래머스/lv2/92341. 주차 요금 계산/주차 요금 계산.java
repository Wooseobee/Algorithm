import java.util.*;

class Solution {
    static class Car {
        String time;
        String status;

        public Car(String time, String status) {
            this.time = time;
            this.status = status;
        }
    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] input = records[i].split(" ");
            String time = input[0];
            int carNum = Integer.parseInt(input[1]);
            String status = input[2];
            if (!map.containsKey(carNum)) {
                map.put(carNum, new ArrayList<>());
                List<String> l = map.get(carNum);
                l.add(time);
                map.put(carNum, l);
            } else {
                List<String> l = map.get(carNum);
                l.add(time);
                map.put(carNum, l);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> fee = new HashMap<>();
        for (int key : map.keySet()) {
            pq.add(key);
            List<String> l = map.get(key);
            int totalTime = 0;
            for (int i = 0; i < l.size(); i += 2) {
                String time1 = l.get(i);
                String time2 = "23:59";
                if (i + 1 < l.size()) {
                    time2 = l.get(i + 1);
                }

                String[] time = time1.split(":");
                int hour1 = Integer.parseInt(time[0]);
                int min1 = Integer.parseInt(time[1]);

                time = time2.split(":");
                int hour2 = Integer.parseInt(time[0]);
                int min2 = Integer.parseInt(time[1]);

                min1 += hour1 * 60;
                min2 += hour2 * 60;

                totalTime += min2 - min1;
            }
            fee.put(key, calculateFee(totalTime, fees));
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int carNum = pq.poll();
            result.add(fee.get(carNum));
            System.out.println(fee.get(carNum));
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static int calculateFee(int totalTime, int[] fees) {
        if (totalTime <= fees[0]) {
            return fees[1];
        } else {
            int total = 0;
            total += fees[1];
            total += Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3];
            return total;
        }
    }
}