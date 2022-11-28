import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        boolean found = false;

        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            list.add(height);
            sum += height;
        }

        for (int i = 0; i < 9; i++) {
            if (found) break;
            for (int j = i + 1; j < 9; j++) {
                int total = sum;
                total -= (list.get(i) + list.get(j));
                if (total == 100) {
                    list.remove(j);
                    list.remove(i);
                    found = true;
                    break;
                }
            }
        }

        Collections.sort(list);

        for (int i = 0; i < 7; i++) {
            System.out.println(list.get(i));
        }
    }
}