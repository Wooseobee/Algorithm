import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] drinks = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            drinks[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(drinks);

        double total = drinks[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (total < drinks[i]) {
                total = total / 2 + drinks[i];
            } else {
                total += (double) drinks[i] / 2;
            }
        }

        if (total == (int) total) {
            System.out.println((int) total);
        } else {
            System.out.println(total);
        }
        br.close();
    }
}