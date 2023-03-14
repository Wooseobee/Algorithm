import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] problems = br.readLine().split("");

        int blue = 0;
        int red = 0;
        if (problems[0].equals("B")) {
            blue++;
        } else {
            red++;
        }
        for (int i = 1; i < n; i++) {
            String now = problems[i];
            if (now.equals(problems[i - 1])) {
                continue;
            } else {
                if (now.equals("B")) {
                    blue++;
                } else {
                    red++;
                }
            }
        }

        System.out.println(Math.min(blue, red) + 1);
        br.close();
    }
}