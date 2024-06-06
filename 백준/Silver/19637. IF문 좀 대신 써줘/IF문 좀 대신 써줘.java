import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static int n;
    private static int[] power;
    private static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        power = new int[n];
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            String name = in[0];
            int limit = Integer.parseInt(in[1]);

            map.putIfAbsent(limit, name);
            power[i] = limit;
        }

        for (int i = 0; i < m; i++) {
            int character = Integer.parseInt(br.readLine());

            int index = findName(character);
            sb.append(map.get(power[index])).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int findName(int now) {
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            int p = power[mid];
            if (p == now) {
                return mid;
            } else if (p > now) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
