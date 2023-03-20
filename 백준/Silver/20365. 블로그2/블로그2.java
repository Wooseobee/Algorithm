import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] colors = br.readLine().toCharArray();
        int blue = colors[0] == 'B' ? 1 : 0;
        int red = colors[0] == 'R' ? 1 : 0;

        for (int i = 1; i < n; i++) {
            if (colors[i - 1] == colors[i])
                continue;
            if (colors[i] == 'B')
                blue++;
            else
                red++;
        }

        System.out.println(Math.min(blue, red) + 1);
        br.close();
    }
}