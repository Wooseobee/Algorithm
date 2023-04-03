import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            if (isGroupWord(input)) cnt++;
        }

        System.out.println(cnt);
        br.close();
    }

    private static boolean isGroupWord(String[] input) {
        int len = input.length;

        for (int i = 0; i < len; i++) {
            char ch = input[i].charAt(0);
            boolean groupWord = true;
            for (int j = i + 1; j < len; j++) {
                if (ch != input[j].charAt(0)) {
                    groupWord = false;
                } else {
                    if (!groupWord) return false;
                }
            }
        }

        return true;
    }
}