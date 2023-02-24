import java.util.*;

class Solution {
    static class Hubo {
        String comb;
        int hit;
        public Hubo(String comb, int hit){
            this.comb = comb;
            this.hit = hit;
        }
    }
    static int n, size;
    static String[] arr;
    static boolean[] visited;
    static List<String> menu = new ArrayList<>();
    static List<String> ans = new ArrayList<>();
    static List<String> order = new ArrayList<>();
    static PriorityQueue<Hubo> pq = new PriorityQueue<>((o1, o2) -> o2.hit - o1.hit);

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        n = orders.length;

        for (int i = 0; i < n; i++) {
            order.add(orders[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < orders[i].length(); j++) {
                String s = String.valueOf(orders[i].charAt(j));
                if (!menu.contains(s)) {
                    menu.add(s);
                }
            }
        }

        Collections.sort(menu);

        for (int i = 0; i < course.length; i++) {
            size = course[i];
            arr = new String[course[i]];
            visited = new boolean[menu.size()];
            selectOrder(0, 0);
            choiceBest();
            pq.clear();
        }
        
        Collections.sort(ans);

        return ans.toArray(new String[ans.size()]);
    }
    
    static void choiceBest(){
        int max = 0;
        if(!pq.isEmpty()){
            Hubo hubo = pq.poll();
            String comb = hubo.comb;
            max = hubo.hit;
            ans.add(comb);
        }
        while(!pq.isEmpty()){
            Hubo hubo = pq.poll();
            if(hubo.hit==max){
                ans.add(hubo.comb);
            } else {
                break;
            }
        }
    }

    static void selectOrder(int start, int depth) {
        if (depth == size) {
            registerMenu();
            return;
        }
        for (int i = start; i < menu.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;

                arr[depth] = menu.get(i);
                selectOrder(i, depth + 1);

                visited[i] = false;
            }
        }
    }

    static void registerMenu() {
        int total = 0;
        for (int j = 0; j < order.size(); j++) {
            String str = order.get(j);
            if(str.length()<size) continue;
            int cnt = 0;
            for (int i = 0; i < size; i++) {
                String s = arr[i];
                if (str.contains(s)) cnt++;
            }
            if (cnt == size) total++;
        }
        if (total >= 2) {
            String s = "";
            for (String str : arr) {
                s += str;
            }
            pq.add(new Hubo(s,total));
        }
    }
}