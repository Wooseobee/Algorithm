import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] doll = new int[n];
        st = new StringTokenizer(br.readLine());

        List<Integer> lionIdx = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            doll[i] = Integer.parseInt(st.nextToken());
            if (doll[i] == 1) lionIdx.add(i);

        }

        int lion = 0;
        int min = 1_000_001;
        int s = 0, e = 0;
        for (int i = 0; i < n; i++) {
            if (doll[i] == 1) lion++;
            if (lion == k) {
                min = Math.min(min, e - s + 1);
            } else if (lion > k) {
                lionIdx.remove(0);
                s = lionIdx.get(0);
                lion--;
                min = Math.min(min, e - s + 1);
            }
            e++;
        }
        if (min==1_000_001) System.out.println(-1);
        else System.out.println(min);
        br.close();
    }
}