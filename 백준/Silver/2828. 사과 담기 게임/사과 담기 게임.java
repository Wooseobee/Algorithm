import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);

        int j = Integer.parseInt(br.readLine());

        int move = 0, left, center, right;

        if (m % 2 == 0) {
            center = m / 2;
        } else {
            center = m / 2 + 1;
        }
        left = 1;
        right = m;

        for (int i = 0; i < j; i++) {
            int idx = Integer.parseInt(br.readLine());

            if (idx > center) {
                while (idx > right) {
                    move++;
                    left++;
                    center++;
                    right++;
                    if (right == n) {
                        break;
                    }
                }
            } else if (idx < center) {
                while (idx < left) {
                    move++;
                    left--;
                    center--;
                    right--;
                    if (left == 1) {
                        break;
                    }
                }
            }
        }
        System.out.println(move);
    }
}