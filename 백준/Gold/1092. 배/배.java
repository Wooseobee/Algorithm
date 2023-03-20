import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        int minBoxWeight = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
            minBoxWeight = Math.min(minBoxWeight, box.get(i));
        }

        Arrays.sort(crane, Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if(crane[0]<box.get(0)){
            System.out.println(-1);
        } else {
            int time = 0;
            while (!box.isEmpty()) {
                time++;
                for (int i = 0; i < n; i++) {
                    int w = crane[i];
                    if (w < minBoxWeight) break;

                    int boxSize = box.size();
                    for (int j = 0; j < boxSize; j++) {
                        if (w >= box.get(j)) {
                            box.remove(j);
                            break;
                        }
                    }
                }
            }
            System.out.println(time);
        }

        br.close();
    }
}