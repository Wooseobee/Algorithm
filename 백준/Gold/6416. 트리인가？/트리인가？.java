import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            int root = 0;
            boolean stop = false;
            boolean isTree = true;
            while (true) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if (u == 0) {
                    k++;
                    break;
                } else if (u == -1) {
                    stop = true;
                    break;
                } else {
                    if (!set.isEmpty() && set.contains(v)) {
                        isTree = false;
                    } else {
                        map.put(u, v);
                        set.add(v);
                    }
                }
            }
            if (stop == true) {
                break;
            }
            if (isTree == false) {
                System.out.println("Case " + k + " is not a tree.");
            } else {
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    if (!set.contains(it.next())) {
                        root++;
                    }
                }
            }
            if (map.isEmpty()) {
                System.out.println("Case " + k + " is a tree.");
            } else if (root == 0 || root > 1) {
                if (isTree != false) {
                    System.out.println("Case " + k + " is not a tree.");
                }
            } else {
                System.out.println("Case " + k + " is a tree.");
            }
        }
        br.close();
    }
}