import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> lecture = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            lecture.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        PriorityQueue<Integer> place = new PriorityQueue<>();
        while (!lecture.isEmpty()) {
            int[] v = lecture.poll();
            int start = v[0];
            int end = v[1];
            if (!place.isEmpty() && place.peek() <= start) {
                place.poll();
            }
            place.add(end);
        }

        System.out.println(place.size());
        br.close();
    }
}