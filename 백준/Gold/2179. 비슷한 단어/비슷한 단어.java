import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> strings = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        String s1 = null, s2 = null, first = null, second = null;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char c = s.charAt(0);
            int len = s.length();
            if (i == 0) {
                first = s;
            } else if (i == 1) {
                second = s;
            }

            for (int j = 0; j < strings.size(); j++) {
                String str = strings.get(j);
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
                        idx = j;
                    } else if (same == max) {
                        if (idx > j) {
                            s1 = str;
                            s2 = s;
                            idx = i;
                        }
                    }
                }
            }
            strings.add(s);
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
