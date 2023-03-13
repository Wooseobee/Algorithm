import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] products = new int[n];

        for (int i = 0; i < n; i++) {
            products[i] = Integer.parseInt(br.readLine());
        }

        products = Arrays.stream(products)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (i + 2 < n) {
                answer += products[i] + products[i + 1];
                i += 2;
            } else {
                answer += products[i];
            }
        }

        System.out.println(answer);

        br.close();
    }
}