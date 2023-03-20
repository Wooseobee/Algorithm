import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] >= 1) {
                pq.add(arr[i]);
            }
        }

        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= -1) {
                if (i + 1 < n && arr[i + 1] <= 0) {
                    sum += arr[i] * arr[i + 1];
                    i++;
                } else {
                    sum += arr[i];
                }
            } else if (arr[i] == 0) {
                continue;
            } else {
                break;
            }
        }

        while (pq.size() > 1) {
            int v1 = pq.poll();
            int v2 = pq.poll();

            if (v1 == 1 || v2 == 1) {
                sum += v1 + v2;
            } else {
                sum += v1 * v2;
            }
        }
        if (!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);
        br.close();
    }
}