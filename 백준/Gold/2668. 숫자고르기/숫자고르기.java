import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer> list = new ArrayList<>();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> plus = new ArrayList<>();
        Set<Integer> ans = new TreeSet<>();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] == i) {
                plus.add(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            list.clear();
            if (arr[i] != i) {
                if (dfs(i)) {
                    ans.addAll(list);
                }
            }
        }

        ans.addAll(plus);
        sb.append(ans.size()).append("\n");
        for (int v : ans) {
            sb.append(v).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean dfs(int idx) {
        if (list.contains(idx)) {
            return checkArr();
        } else {
            list.add(idx);
            return dfs(arr[idx]);
        }
    }

    private static boolean checkArr() {
        Set<Integer> set = new HashSet<>();
        for (int v : list) {
            set.add(arr[v]);
        }
        return set.size() == list.size();
    }
}
