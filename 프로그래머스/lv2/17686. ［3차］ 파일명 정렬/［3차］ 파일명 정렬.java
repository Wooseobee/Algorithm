import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static class File {
        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }

    public String[] solution(String[] files) {
        List<File> answer = new ArrayList<>();

        for (String file : files) {
            String[] divide = file.trim().split("[0-9]"); // 숫자로 분리
            String head = divide[0];
            int len = head.length();
            String number;
            if (len + 5 > file.length()) {
                number = file.substring(len).replaceAll("[^0-9]", " ").split(" ")[0];
            } else {
                number = file.substring(len, len + 5).replaceAll("[^0-9]", " ").split(" ")[0];
            }
            int len2 = number.length();
            String tail = "" + file.substring(len + len2);
            answer.add(new File(head, number, tail));
        }

        return answer.stream().sorted(new Comparator<>() {
            @Override
            public int compare(File f1, File f2) {
                if (f1.head.toUpperCase().equals(f2.head.toUpperCase())) {
                    return Integer.parseInt(f1.number) - Integer.parseInt(f2.number);
                }
                return f1.head.toUpperCase().compareTo(f2.head.toUpperCase());
            }
        }).map(f1 -> new String(f1.head + f1.number + f1.tail)).collect(Collectors.toList()).toArray(new String[0]);
    }
}