import java.io.*;
import java.util.*;

public class Main {
    static class Jewelry {
        int w;
        int v;

        public Jewelry(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> bag = new ArrayList<>();
        List<Jewelry> jewelries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < k; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bag);
        jewelries.sort((o1, o2) -> o1.w - o2.w);

        long max = 0;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : bag) {
            while (idx < n && jewelries.get(idx).w <= w) {
                pq.add(jewelries.get(idx++).v);
            }
            if (!pq.isEmpty()) max += pq.poll();
        }

        System.out.println(max);
        br.close();
    }
}