import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        Collections.sort(list);

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int v = Integer.parseInt(input[i]);
            int left = 0;
            int right = list.size() - 1;
            int mid;
            while (left < right) {
                mid = (left + right) / 2;
                if (list.get(mid) > v) {
                    right = mid - 1;
                } else if (list.get(mid) < v) {
                    left = mid + 1;
                } else {
                    left = mid;
                    break;
                }
            }
            if (list.get(left) == v) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}