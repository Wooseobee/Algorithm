import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        String[] todayDate = today.split("\\.");
        String todayYear = todayDate[0];
        String todayMonth = todayDate[1];
        String todayDay = todayDate[2];

        Map<String, Integer> term = new HashMap<>();
        List<Integer> removeList = new ArrayList<>();

        for (String t : terms) {
            String[] types = t.split(" ");
            term.put(types[0], Integer.parseInt(types[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] date = privacy[0].split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            String type = privacy[1];

            int duration = term.get(type);

            if (month + duration > 12) {
                year += 1;
                month += duration - 12;
            } else {
                month += duration;
            }
            day --;
            String Month, Day;
            if (month < 10) {
                Month = "0".concat(String.valueOf(month));
            } else {
                Month = String.valueOf(month);
            }
            if (day < 10) {
                Day = "0".concat(String.valueOf(day));
            } else {
                Day = String.valueOf(day);
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

            if (dateFormat.parse(todayYear + todayMonth + todayDay)
                    .after(dateFormat.parse(year + Month + Day))) {
                removeList.add(i + 1);
            }
        }

        return removeList.stream().mapToInt(Integer::intValue).toArray();
    }
}