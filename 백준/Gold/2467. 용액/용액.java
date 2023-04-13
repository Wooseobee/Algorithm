import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] liquid = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        liquid = Arrays.stream(liquid)
                .boxed().sorted()
                .mapToInt(Integer::intValue)
                .toArray();

        int sum = 2_000_000_000;

        int liquid1 = 0, liquid2 = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            int left = liquid[l];
            int right = liquid[r];
            int nowSum = Math.abs(left + right);
            if (nowSum < sum) {
                liquid1 = left;
                liquid2 = right;
                sum = nowSum;
            }
            if (Math.abs(left) < Math.abs(right)) r--;
            else l++;
        }
        System.out.println(liquid1 + " " + liquid2);
        br.close();
    }
}