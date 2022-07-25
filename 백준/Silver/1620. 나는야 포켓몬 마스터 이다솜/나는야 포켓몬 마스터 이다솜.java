import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s[] = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        HashMap<String, Integer> hashMap = new HashMap<>();
        String strings[] = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            hashMap.put(str, i);
            strings[i]=str;
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                sb.append(strings[Integer.parseInt(str) - 1] + "\n");
            } else {
                sb.append(hashMap.get(str) + 1 + "\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}