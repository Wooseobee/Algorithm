import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        Map<String, Integer> A = new HashMap<>();
        Map<String, Integer> B = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            if (!checkStr(str1.charAt(i), str1.charAt(i + 1))) continue;
            String s = String.valueOf(str1.charAt(i)) + str1.charAt(i + 1);
            A.put(s, A.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if (!checkStr(str2.charAt(i), str2.charAt(i + 1))) continue;
            String s = String.valueOf(str2.charAt(i)) + str2.charAt(i + 1);
            B.put(s, B.getOrDefault(s, 0) + 1);
        }

        int gyo = 0;
        int hap = 0;

        Set<String> AKey = A.keySet();
        Set<String> BKey = B.keySet();
        for (String key : AKey) {
            if (BKey.contains(key)) {
                gyo += Math.min(A.get(key), B.get(key));
            }
            hap += Math.max(A.get(key), B.getOrDefault(key, 0));
        }
        for (String key : BKey) {
            if (!AKey.contains(key)) {
                hap += B.get(key);
            }
        }
        if (hap == 0) return 65_536;

        return (int) ((double) gyo / hap * 65_536);
    }

    private static boolean checkStr(char ch1, char ch2) {
        String s1 = String.valueOf(ch1) + ch2;
        s1 = s1.replaceAll("[^A-Z]", "");
        return s1.length() == 2;
    }
}