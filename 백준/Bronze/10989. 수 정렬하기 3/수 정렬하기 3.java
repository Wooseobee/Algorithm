import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[10_001];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= 10_000; i++) {
            if (arr[i] != 0) {
                for (int j = 0; j < arr[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}