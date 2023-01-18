import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < input.length; i++) {
            pq.add(Integer.parseInt(input[i]));
        }

        while (!pq.isEmpty()) {
            bw.write(String.valueOf(pq.poll()));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}