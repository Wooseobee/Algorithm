import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] stick;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        stick = new int[5];
        for (int i = 0; i < 5; i++) {
            stick[i] = Integer.parseInt(input[i]);
        }
        while (!isSorted(stick)) {
            sorting();
        }
    }

    static boolean isSorted(int[] stick) {
        for (int i = 0; i < 5; i++) {
            if (stick[i] != i + 1) return false;
        }
        return true;
    }

    static void sorting() {
        for (int i = 0; i < 4; i++) {
            if (stick[i] > stick[i + 1]) {
                int tmp = stick[i + 1];
                stick[i + 1] = stick[i];
                stick[i] = tmp;

                for (int j = 0; j < 5; j++) {
                    System.out.print(stick[j] + " ");
                }
                System.out.println();
            }
        }
    }
}