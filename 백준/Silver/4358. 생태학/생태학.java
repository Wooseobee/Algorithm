import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeMap<String, Double> dict = new TreeMap<>();

        int cnt = 0;

        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            if (dict.containsKey(input)) {
                dict.put(input, dict.get(input) + 1);
            } else {
                dict.put(input, 1.0);
            }
            cnt++;
        }
        br.close();
        Map.Entry<String, Double> entry = null;

        while (!dict.isEmpty()) {
            entry = dict.firstEntry();
            sb.append(entry.getKey() + " " + String.format("%.4f", entry.getValue() / cnt * 100) + "\n");
            dict.remove(entry.getKey());
        }
        System.out.println(sb);
    }
}