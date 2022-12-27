import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int[] arr = new int[101];
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        int total = 0;
        int max = 0;
        int min = 100;

        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            if (max < Integer.parseInt(input[1])) {
                max = Integer.parseInt(input[1]);
            }
            if (min > Integer.parseInt(input[0])) {
                min = Integer.parseInt(input[0]);
            }
            for (int j = Integer.parseInt(input[0]) + 1; j <= Integer.parseInt(input[1]); j++) {
                arr[j]++;
            }
        }

        for (int i = min; i <= max; i++) {
            switch (arr[i]) {
                case 1:
                    total += a;
                    break;
                case 2:
                    total += (2 * b);
                    break;
                case 3:
                    total += (3 * c);
                    break;
            }
        }
        System.out.println(total);
    }
}