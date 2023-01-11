import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int idx = k - 1;

        List<Integer> circle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            circle.add(i + 1);
        }

        bw.write("<");
        while (circle.size() != 1) {
            bw.write(circle.get(idx) + ", ");
            circle.remove(idx);
            n--;
            idx = (idx + k - 1) % n;
        }
        bw.write(circle.get(0) + ">");

        bw.flush();
        bw.close();
        br.close();
    }
}