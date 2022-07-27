import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int T = Integer.parseInt(br.readLine());
        Map.Entry<Integer, Integer> minEntry = null;
        Map.Entry<Integer, Integer> maxEntry = null;

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());

            for (int j = 0; j < k; j++) {
                String s[] = br.readLine().split(" ");
                if (s[0].equals("I")) {
                    if (map.containsKey(Integer.parseInt(s[1]))) {
                        map.put(Integer.parseInt(s[1]), map.get(Integer.parseInt(s[1])) + 1);
                    } else {
                        map.put(Integer.parseInt(s[1]), 1);
                    }
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }
                    if (Integer.parseInt(s[1]) == -1) {
                        minEntry = map.firstEntry();
                        if (minEntry.getValue() == 1) {
                            map.remove(minEntry.getKey());
                        } else {
                            map.put(minEntry.getKey(), minEntry.getValue() - 1);
                        }
                    } else {
                        maxEntry = map.lastEntry();
                        if (maxEntry.getValue() == 1) {
                            map.remove(maxEntry.getKey());
                        } else {
                            map.put(maxEntry.getKey(), maxEntry.getValue() - 1);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                minEntry = map.firstEntry();
                maxEntry = map.lastEntry();
                sb.append(maxEntry.getKey() + " " + minEntry.getKey() + "\n");
            }
            map.clear();
        }
        br.close();
        System.out.println(sb);
    }
}