import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        String bench = br.readLine();
        boolean[] eat = new boolean[n];
        boolean[] eaten = new boolean[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            char now = bench.charAt(i);
            if (now == 'H') {
                if (!eaten[i]) {
                    for (int j = i + 1; j <= i + k && j < n; j++) {
                        char next = bench.charAt(j);
                        if (next == 'P' && !eat[j]) {
                            max++;
                            eat[j] = true;
                            eaten[i] = true;
                            break;
                        }
                    }
                }
            } else {
                if (!eat[i]) {
                    for (int j = i + 1; j <= i + k && j < n; j++) {
                        char next = bench.charAt(j);
                        if (next == 'H' && !eaten[j]) {
                            max++;
                            eat[i] = true;
                            eaten[j] = true;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(max);
        br.close();
    }
}