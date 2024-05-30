import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Set<Integer> set = new HashSet<>();
        int start = 0, end = 0;
        long totalCount = 0;

        while (end < n) {
            if (!set.contains(arr[end])) {
                set.add(arr[end]);
                end++;
                totalCount += (end - start);
            } else {
                set.remove(arr[start]);
                start++;
            }
        }

        System.out.println(totalCount);
        br.close();
    }

}