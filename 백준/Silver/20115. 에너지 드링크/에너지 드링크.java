import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] drinks = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(drinks);

        double total = drinks[n-1];
        for (int i = n - 2; i >= 0; i--) {
            total += (double) drinks[i] / 2;
        }

        if (total == (int) total) {
            System.out.println((int) total);
        } else {
            System.out.println(total);
        }
        br.close();
    }
}