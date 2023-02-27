import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] road = new long[n - 1];
        long[] gas = new long[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++) {
            road[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            gas[i] = Integer.parseInt(input[i]);
        }

        long min = gas[0];
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, gas[i]);
            sum += (min * road[i]);
        }

        System.out.println(sum);
        br.close();
    }
}