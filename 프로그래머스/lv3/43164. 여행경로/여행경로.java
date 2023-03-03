import java.util.*;

class Solution {
    static Map<String, List<Ticket>> map = new HashMap<>();
    static List<String> ansList = new ArrayList<>();
    static int ticketTotal;

    public String[] solution(String[][] tickets) {
        ticketTotal = tickets.length;

        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            if (!map.containsKey(start)) {
                map.put(start, new ArrayList<>());
            }
            map.get(start).add(new Ticket(start, end, i));
        }

        for (List<Ticket> list : map.values()) {
            list.sort((o1, o2) -> o1.end.compareTo(o2.end));
        }

        bfs();

        return ansList.toArray(new String[0]);
    }

    static class Ticket {
        String start;
        String end;
        int ticketNum;

        public Ticket(String start, String end, int ticketNum) {
            this.start = start;
            this.end = end;
            this.ticketNum = ticketNum;
        }

        @Override
        public boolean equals(Object object) {
            Ticket ticket = (Ticket) object;

            return ticket.ticketNum == this.ticketNum;
        }
    }

    static void bfs() {
        Queue<List<Ticket>> q = new LinkedList<>();
        for (Ticket t : map.get("ICN")) {
            List<Ticket> list = new ArrayList<>();
            list.add(new Ticket("ICN", t.end, t.ticketNum));
            q.add(list);
        }

        while (!q.isEmpty()) {
            List<Ticket> path = q.poll();
            int size = path.size();
            String end = path.get(size - 1).end;

            if (size == ticketTotal) {
                ansList.add("ICN");
                for (Ticket t : path) {
                    ansList.add(t.end);
                }
                return;
            }

            if (map.containsKey(end)) {
                for (Ticket next : map.get(end)) {
                    Ticket nextTicket = new Ticket(next.start, next.end, next.ticketNum);
                    if (!path.contains(nextTicket)) {
                        List<Ticket> newPath = new ArrayList<>();
                        for (Ticket t : path) {
                            newPath.add(t);
                        }
                        newPath.add(nextTicket);
                        q.add(newPath);
                    }
                }
            }
        }
    }
}