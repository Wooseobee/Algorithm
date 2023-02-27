import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        arr = Arrays.stream(arr)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int money = arr[i] - ((i + 1) - 1);
            sum += Math.max(money, 0);
        }

        System.out.println(sum);
        br.close();
    }
}