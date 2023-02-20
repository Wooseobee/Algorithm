import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int minL = 0;
        int minR = 0;
        int minMid = 0;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int r = n - 1;
            while (j < r) {
                long sum = (long) arr[i] + arr[j] + arr[r];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    minL = arr[i];
                    minMid = arr[j];
                    minR = arr[r];
                }

                if (sum > 0) r--;
                else j++;
            }
        }

        System.out.println(minL + " " + minMid + " " + minR);
        br.close();
    }
}