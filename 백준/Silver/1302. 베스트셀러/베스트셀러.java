import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        String maxBookName = "";

        List<String> BookList = new ArrayList<>();
        Map<String, Integer> BookCnt = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            if (!BookList.contains(book)) {
                BookCnt.put(book, 1);
                BookList.add(book);
            } else {
                BookCnt.put(book, BookCnt.get(book) + 1);
            }
        }

        Collections.sort(BookList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < BookList.size(); i++) {
            String bookName = BookList.get(i);
            int sellNum = BookCnt.get(bookName);
            if (max < sellNum) {
                max = sellNum;
                maxBookName = bookName;
            }
        }

        System.out.println(maxBookName);

        br.close();
    }
}