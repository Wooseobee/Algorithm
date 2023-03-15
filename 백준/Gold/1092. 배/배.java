import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] crane = new int[n];
        int maxCraneWeight = 0;
        int minCraneWeight = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
            maxCraneWeight = Math.max(maxCraneWeight, crane[i]);
            minCraneWeight = Math.min(minCraneWeight, crane[i]);
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        int maxBoxWeight = 0;
        int minBoxWeight = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
            maxBoxWeight = Math.max(maxBoxWeight, box.get(i));
            minBoxWeight = Math.min(minBoxWeight, box.get(i));
        }

        crane = Arrays.stream(crane)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        box.sort(Collections.reverseOrder());

        boolean canMove = maxBoxWeight <= maxCraneWeight;

        int time = 0;
        while (canMove) {
            time++;
            for (int i = 0; i < n; i++) {
                int w = crane[i];
                if (w < minBoxWeight) break;
                
                for (int j = 0; j < box.size(); j++) {
                    if (w >= box.get(j)) {
                        box.remove(j);
                        break;
                    }
                }
            }
            if (box.isEmpty()) {
                break;
            }
        }
        if (canMove) {
            System.out.println(time);
        } else {
            System.out.println(-1);
        }

        br.close();
    }
}