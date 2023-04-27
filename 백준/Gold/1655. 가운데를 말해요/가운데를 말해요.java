import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int v = Integer.parseInt(br.readLine());
            if (i % 2 != 0) {
                minHeap.add(v);
            } else {
                maxHeap.add(v);
            }

            if (maxHeap.size() != 0 && minHeap.size() != 0 && maxHeap.peek() > minHeap.peek()) {
                int tmp = maxHeap.poll();
                maxHeap.add(minHeap.poll());
                minHeap.add(tmp);
            }
            if (maxHeap.size() == minHeap.size()) {
                sb.append(maxHeap.peek()).append("\n");
            } else {
                sb.append(minHeap.peek()).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}