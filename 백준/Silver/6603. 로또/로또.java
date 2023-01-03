import java.io.*;
import java.util.*;

public class Main {;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while (true) {
            String[] s = br.readLine().split(" ");
            int k = Integer.parseInt(s[0]);

            if (k==0) break;

            int[] answer = new int[6];
            int[] arr = new int[k];
            boolean[] visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(s[i + 1]);
            }
            bruteForce(arr);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bruteForce(int[] arr) throws IOException {
        Set<List<Integer>> set = new LinkedHashSet<>();
        int n = arr.length;
        for (int i = 0; i < n - 5; i++) {
            for (int j = i+1; j < n - 4; j++) {
                for (int k = j+1; k < n - 3; k++) {
                    for (int l = k+1; l < n - 2; l++) {
                        for (int m = l+1; m < n - 1; m++) {
                            for (int o = m + 1; o < n; o++) {
                                List<Integer> list = new ArrayList<>();
                                list.add(arr[i]);
                                list.add(arr[j]);
                                list.add(arr[k]);
                                list.add(arr[l]);
                                list.add(arr[m]);
                                list.add(arr[o]);
                                set.add(list);
                            }
                        }
                    }
                }
            }
        }
        
        Iterator<List<Integer>> it = set.iterator();
        while (it.hasNext()) {
            List<Integer> list = it.next();
            for (int v : list) {
                bw.write(v + " ");
            }
            bw.write("\n");
        }
    }
}