import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken().replaceAll("[:]", ""));
        int e = Integer.parseInt(st.nextToken().replaceAll("[:]", ""));
        int q = Integer.parseInt(st.nextToken().replaceAll("[:]", ""));

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();

        String chat;
        while ((chat = br.readLine()) != null && !chat.isEmpty()) {
            st = new StringTokenizer(chat);
            int time = Integer.parseInt(st.nextToken().replaceAll("[:]", ""));
            String name = st.nextToken();
            if (time <= s) {
                before.add(name);
            } else if (time >= e && time <= q) {
                after.add(name);
            }
        }

        int cnt = 0;
        for (String str : before) {
            if (after.contains(str)) {
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}