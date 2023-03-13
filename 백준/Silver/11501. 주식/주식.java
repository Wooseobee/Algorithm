import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long benefit = 0;
            String[] input = br.readLine().split(" ");

            int max = Integer.parseInt(input[n - 1]);
            for (int j = n - 2; j >= 0; j--) {
                int v = Integer.parseInt(input[j]);
                if (v > max) {
                    max = v;
                } else if (v < max) {
                    benefit += max - v;
                }
            }
            sb.append(benefit).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}