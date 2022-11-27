import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int min = Integer.MAX_VALUE;

        int[] list = new int[n + 1];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(input[i]);
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        while (start <= n && end <= n) {
            if (sum >= s) {
                min = Math.min(min, end - start);
                sum -= list[start++];
            } else {
                sum += list[end++];
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
        br.close();
    }
}