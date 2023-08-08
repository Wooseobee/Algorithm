import java.util.*;
class Solution {
    class Time {
        int h;
        int m;
        public Time(int h, int m) {
            this.h = h;
            this.m = m;
        }
    }
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
		PriorityQueue<Time> pq = new PriorityQueue<>((o1, o2) -> o1.h == o2.h ? o1.m - o2.m : o1.h - o2.h);
        for(String time : timetable) {
            String[] input = time.split(":");
            int hour = Integer.parseInt(input[0]);
            int min = Integer.parseInt(input[1]);
            pq.add(new Time(hour, min));
        }
        
        Time last = pq.peek();
        int sH = 9, sM = -t;
        int aH = 0, aM = 0;
        for(int time = 0; time < n; time++) {
            sM += t;
            int total = 0;
            if(sM >= 60) {
                sH++;
                sM -= 60;
            }
            
            while(!pq.isEmpty() && total < m) {
                Time people = pq.peek();
                aH = people.h;
                aM = people.m - 1;

                if(people.h > sH || (people.h == sH && people.m > sM)) {                    
                    break;
                }
                pq.poll();
                total++;
            }
            if(total < m) {
                aH = sH;
                aM = sM;
            }
        }
        while(aH >= 1 && aM < 0) {
            aH--;
            aM+=60;
        }
        while(aH < 23 && aM >= 60) {
            aH++;
            aM-=60;
        }
        answer = aH < 10 ? answer + "0" + aH : answer + aH;
        answer += ":";
        answer = aM < 10 ? answer + "0" + aM : answer + aM;
        /*
        1. pq에 다 때려박기
        2. 09시부터 하나씩 뽑기
        */
        return answer;
    }
}