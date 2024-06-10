import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String keyword = br.readLine();

            map.put(keyword, true);
        }

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(",");
            for (String k : in) {
                map.remove(k);
            }
            sb.append(map.size()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}
