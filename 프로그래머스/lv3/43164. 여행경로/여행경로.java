import java.util.*;

class Solution {
    static int ticketTotal;
    static boolean[] visited;
    static String course;

    public String[] solution(String[][] tickets) {
        ticketTotal = tickets.length;
        visited = new boolean[ticketTotal];

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) {
                    return o2[1].compareTo(o1[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });

        dfs(0, "ICN", "ICN", tickets);

        return course.split(" ");
    }

    static void dfs(int depth, String start, String travelWay, String[][] tickets){
        if (depth == ticketTotal) {
            course = travelWay;
        }else{
            for (int i = 0; i < ticketTotal; i++) {
                if (!visited[i] && tickets[i][0].equals(start)) {
                    visited[i] = true;
                    dfs(depth + 1, tickets[i][1], travelWay + " " + tickets[i][1], tickets);
                    visited[i] = false;
                }
            }
        }
    }
}