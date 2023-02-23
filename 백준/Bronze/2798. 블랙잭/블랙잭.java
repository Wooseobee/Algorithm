import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] cards = new int[n];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(input[i]);
        }
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= m) {
                        if (Math.abs(m - answer) > Math.abs(m - sum)) {
                            answer = sum;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}