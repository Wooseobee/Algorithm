import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, List<String[]>> alphabet = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int max = 0, idx = 0;
        String s1 = null, s2 = null, first = null, second = null;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char c = s.charAt(0);
            int len = s.length();
            if (i == 0) {
                first = s;
            } else if (i == 1) {
                second = s;
            }

            List<String[]> list = alphabet.getOrDefault(c, null);
            if (list == null) {
                list = new ArrayList<>();
                list.add(new String[]{s, String.valueOf(i)});
                alphabet.put(c, list);
                continue;
            }
            for (int j = 0; j < list.size(); j++) {
                String[] strings = list.get(j);
                String str = strings[0];
                int same = 0;
                for (int k = 0; k < Math.min(str.length(), len); k++) {
                    char c1 = str.charAt(k);
                    char c2 = s.charAt(k);
                    if (c1 == c2) {
                        same++;
                    } else {
                        break;
                    }
                }

                if (!str.equals(s)) {
                    if (same > max) {
                        max = same;
                        s1 = str;
                        s2 = s;
                        idx = Integer.parseInt(strings[1]);
                    } else if (same == max) {
                        if (idx > Integer.parseInt(strings[1])) {
                            s1 = str;
                            s2 = s;
                            idx = Integer.parseInt(strings[1]);
                        }
                    }
                }
            }
            list.add(new String[]{s, String.valueOf(i)});
        }

        if (s1 == null) {
            System.out.println(first);
            System.out.println(second);
        } else {
            System.out.println(s1);
            System.out.println(s2);
        }
        br.close();
    }
}
