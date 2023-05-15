import java.util.*;

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
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                File f1 = getFile(s1);
                File f2 = getFile(s2);

                if (f1.head.equals(f2.head)) {
                    return Integer.parseInt(f1.number) - Integer.parseInt(f2.number);
                }
                return f1.head.compareTo(f2.head);
            }
        });

        return files;
    }

    private static File getFile(String file) {
        String[] divide = file.split("[0-9]"); // 숫자로 분리 ==> HEAD 분리
        String head = divide[0].toUpperCase();
        int len = head.length();
        String number;
        number = file.substring(len).replaceAll("[^0-9]", " ").split(" ")[0];
        
        int len2 = number.length();
        String tail = "" + file.substring(len + len2);  // 나머지 TAIL
        return new File(head, number, tail);
    }
}