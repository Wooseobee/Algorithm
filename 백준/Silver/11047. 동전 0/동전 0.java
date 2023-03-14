import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        PriorityQueue<Integer> coins = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while (k != 0 && !coins.isEmpty()) {
            int v = coins.poll();
            cnt += k / v;
            k %= v;
        }

        System.out.println(cnt);
        br.close();
    }
}