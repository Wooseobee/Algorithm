import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, cnt;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];

            String[] input = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                arr[j + 1] = Integer.parseInt(input[j]);
            }

            cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    checkCycle(j);
                    cnt++;
                }
            }
            checkCycle(1);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void checkCycle(int idx) {
        if (!visited[idx]) {
            visited[idx] = true;
            checkCycle(arr[idx]);
        }
    }
}