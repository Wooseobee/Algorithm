import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int l = Integer.parseInt(in[1]);

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            int s = Integer.parseInt(in[0]);
            int e = Integer.parseInt(in[1]);

            list.add(new int[]{s, e});
        }

        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int res = 0;
        int len = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);
            int s = now[0];
            int e = now[1];
            for (int j = s; j < e; j++) {
                if (len < j) {
                    res++;
                    len = j + l - 1;
                }
            }
        }
        System.out.println(res);
        br.close();
    }
}
