import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("^[{]{2}|[}]{2}$", "");
        String[] strings = s.split("[}]{1}[,]{1}[{]{1}");

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> o1.length() - o2.length());
        pq.addAll(Arrays.asList(strings));

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            String str = pq.poll();

            String[] strs = str.split(",");

            for(String ss : strs){
                if (!ans.contains(Integer.parseInt(ss))) {
                    ans.add(Integer.parseInt(ss));
                }
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}