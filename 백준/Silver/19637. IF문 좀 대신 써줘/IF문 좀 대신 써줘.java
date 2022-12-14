import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class power {
        String title;
        int power;

        public power(String title, int power) {
            this.title = title;
            this.power = power;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<power> powerList = new ArrayList<>();

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            powerList.add(new power(s[0], Integer.parseInt(s[1])));
        }

        for (int i = 0; i < m; i++) {
            int characterPower = Integer.parseInt(br.readLine());
            int left = 0, right = n - 1, mid;

            while (left <= right) {
                mid = (left + right) / 2;

                if (characterPower > powerList.get(mid).power) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            bw.write(powerList.get(left).title + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}