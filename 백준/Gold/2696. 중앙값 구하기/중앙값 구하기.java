import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//Maxheap , Minheap 두 개의 우선순위 큐 이용
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine());
            int cnt = 0;

            while (M > 0) {
                String s[] = br.readLine().split(" ");
                for (int j = 1; j <= 10 && j <= M; j++) {
                    int x = Integer.parseInt(s[j - 1]);
                    if (j % 2 == 1) {
                        maxHeap.add(x);
                    } else {
                        minHeap.add(x);
                    }
                    if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                        int tmp = minHeap.remove();
                        minHeap.add(maxHeap.remove());
                        maxHeap.add(tmp);
                    }
                    if (j % 2 == 1) {
                        sb.append(maxHeap.peek() + " ");
                        cnt++;
                        if (cnt % 10 == 0) {
                            sb.append("\n");
                        }
                    }
                }
                M -= 10;
            }
            System.out.println(cnt + "\n" + sb);
            sb.setLength(0);
            maxHeap.clear();
            minHeap.clear();
        }
        br.close();
    }
}