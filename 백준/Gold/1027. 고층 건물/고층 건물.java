import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        buildings = new int[n];
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(in[i]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt1 = findLeft(i);
            int cnt2 = findRight(i);
            max = Math.max(max, cnt1 + cnt2);
        }

        System.out.println(max);
        br.close();
    }

    private static int findLeft(int i) {
        Stack<Double> min = new Stack<>();
        int h1 = buildings[i--];
        double dist = 1;
        int cnt = 0;
        while (i >= 0) {
            int h2 = buildings[i--];
            double lean = (h1 - h2) / dist++;
            while (!min.isEmpty() && min.peek() > lean) {
                min.pop();
            }
            if (min.isEmpty()) {
                cnt++;
                min.add(lean);
            }
        }
        return cnt;
    }

    private static int findRight(int i) {
        Stack<Double> max = new Stack<>();
        int h1 = buildings[i++];
        double dist = 1;
        int cnt = 0;
        while (i < n) {
            int h2 = buildings[i++];
            double lean = (h2 - h1) / dist++;
            while (!max.isEmpty() && max.peek() < lean) {
                max.pop();
            }
            if (max.isEmpty()) {
                cnt++;
                max.add(lean);
            }
        }
        return cnt;
    }
}
