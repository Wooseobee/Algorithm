import java.io.*;
import java.util.*;

public class Main {
    static class Coordinate {
        int idx;
        int value;

        public Coordinate(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Coordinate> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Set<Integer> set = new HashSet<>();
        int[] arr = new int[n];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            pq.add(new Coordinate(i, Integer.parseInt(input[i])));
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Coordinate c = pq.poll();
            ans[c.idx] = cnt;
            if (!pq.isEmpty()) {
                if (pq.peek().value != c.value) cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}