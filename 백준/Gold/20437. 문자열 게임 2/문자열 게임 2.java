import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            countLength(w, k);
        }

        System.out.println(sb);
        br.close();
    }

    private static void countLength(String w, int k) {
        Map<Character, List<Integer>> alphabet = new HashMap<>();
        int minLen = 10_001;
        int maxLen = 0;
        int len = w.length();
        for (int i = 0; i < len; i++) {
            char ch = w.charAt(i);
            List<Integer> list = alphabet.computeIfAbsent(ch, k1 -> new ArrayList<>());
            list.add(i);
            int size = list.size();
            if (size == k) {
                minLen = Math.min(minLen, i - list.get(0) + 1);
                maxLen = Math.max(maxLen, i - list.get(0) + 1);
            } else if (size > k) {
                minLen = Math.min(minLen, i - list.get(size - k) + 1);
                maxLen = Math.max(maxLen, i - list.get(size - k) + 1);
            }
        }
        if (minLen == 10_001 || maxLen == 0) {
            sb.append("-1").append("\n");
        } else {
            sb.append(minLen).append(" ").append(maxLen).append("\n");
        }
    }
}