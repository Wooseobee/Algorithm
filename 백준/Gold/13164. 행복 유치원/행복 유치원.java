import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] student = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = student[i + 1] - student[i];
        }

        Arrays.sort(diff);

        int total = 0;
        for (int i = 0; i < n - k; i++) {
            total += diff[i];
        }

        System.out.println(total);
        br.close();
    }
}