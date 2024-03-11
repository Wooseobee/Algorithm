import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int score = Integer.parseInt(input[1]);
        int p = Integer.parseInt(input[2]);

        if (n != 0) {
            input = br.readLine().split(" ");
        }
        List<Integer> list = new ArrayList<>();
        int rank = 1;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(input[i]);
            if (now > score) {
                rank++;
                list.add(now);
            } else if (now < score) {
                break;
            } else {
                list.add(now);
            }
        }
        list.add(score);

        if (list.size() <= p) {
            System.out.println(rank);
        } else {
            System.out.println(-1);
        }
        br.close();
    }
}