import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] rope = new int[n];

        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        rope = Arrays.stream(rope)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        int max = rope[0];
        for (int i = 1; i < n; i++) {
            if (max < rope[i] * (i + 1)) {
                max = rope[i] * (i + 1);
            }
        }

        System.out.println(max);
        br.close();
    }
}