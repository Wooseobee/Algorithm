import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            if (checkPalindrome(arr, s, e)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean checkPalindrome(int[] arr, int s, int e) {
        while (s <= e) {
            if (arr[s] != arr[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}