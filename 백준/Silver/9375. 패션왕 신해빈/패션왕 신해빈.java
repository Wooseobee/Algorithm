import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            List<String> type = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                String[] s = br.readLine().split(" ");

                if (map.containsKey(s[1])) {
                    map.put(s[1], map.get(s[1]) + 1);
                } else {
                    map.put(s[1], 1);
                    type.add(s[1]);
                }
            }

            int total = 1;

            for (int value : map.values()) {
                total *= (value + 1);
            }

            System.out.println(total - 1);
        }
        br.close();
    }
}