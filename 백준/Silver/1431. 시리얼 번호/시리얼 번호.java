import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length() || o1.length() > o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    int sum1 = 0, sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (Character.isDigit(o1.charAt(i))) sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                    }
                    for (int i = 0; i < o2.length(); i++) {
                        if (Character.isDigit(o2.charAt(i))) sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                    }
                    if (sum1 == sum2) return o1.compareTo(o2);
                    return sum1 - sum2;
                }
            }
        });
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            pq.add(input);
        }

        while (!pq.isEmpty()) {
            bw.write(pq.poll() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}