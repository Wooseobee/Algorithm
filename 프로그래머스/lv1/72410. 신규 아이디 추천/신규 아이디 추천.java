import java.util.*;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = chap2(new_id);
        new_id = chap3(new_id);
        if (new_id.length() > 0) {
            new_id = new_id.charAt(0) == '.' ? new_id.replaceFirst(".", "") : new_id;
        }
        if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        if (new_id.contains(" ")) {
            new_id = new_id.replace(" ", "a");
        }
        if (new_id.equals("")) {
            new_id = "a";
        }

        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        } else if (new_id.length() <= 2) {
            while (new_id.length() < 3) {
                new_id = new_id.concat(String.valueOf(new_id.charAt(new_id.length() - 1)));
            }
        }

        return new_id;
    }

    static String chap2(String id) {
        String new_id = id;
        Set<String> list = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            list.add(Character.toString('a' + i));
        }
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        list.add("-");
        list.add("_");
        list.add(".");

        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (!list.contains(String.valueOf(ch))) {
                new_id = new_id.replace(String.valueOf(ch), "");
                i--;
            }
        }

        return new_id;
    }

    static String chap3(String id) {
        String new_id = id;

        for (int i = 0; i < new_id.length(); i++) {
            if (new_id.charAt(i) == '.') {
                int j = i + 1;
                while (j < new_id.length() && new_id.charAt(j) == '.') {
                    j++;
                }
                new_id = new_id.substring(0, i) + new_id.substring(j - 1);
            }
        }
        return new_id;
    }
}