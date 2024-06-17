import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            int max = Integer.parseInt(in[n - 1]);
            long earn = 0;
            for (int j = n - 2; j >= 0; j--) {
                int v = Integer.parseInt(in[j]);
                if (v < max) {
                    earn += max - v;
                } else {
                    max = v;
                }
            }
            sb.append(earn).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
