import java.io.*;
import java.util.*;

public class Main {

    private static class City {
        int next;
        int point;

        public City(int next, int point) {
            this.next = next;
            this.point = point;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int m = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);
        int[][] arr = new int[m][n];
        List<Integer>[] list = new List[m];

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            Set<Integer> set = new TreeSet<>();

            for (int j = 0; j < n; j++) {
                int size = Integer.parseInt(in[j]);
                arr[i][j] = size;
                set.add(size);
            }
            list[i] = new ArrayList<>(set);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Collections.binarySearch(list[i], arr[i][j]);
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (Arrays.equals(arr[i], arr[j])) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
