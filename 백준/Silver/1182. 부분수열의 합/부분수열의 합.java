import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int cnt = 0, n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        arr = new int[n];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        solution(0, 0);
        System.out.println(s == 0 ? cnt - 1 : cnt);
        br.close();
    }

    static void solution(int depth, int sum) {
        if (depth == n) {
            if (sum == s) cnt++;
            return;
        }

        solution(depth + 1, sum + arr[depth]);
        solution(depth + 1, sum);
    }
}