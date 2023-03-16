import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> applicant = new ArrayList<>();

            int min1 = 1;
            int min2 = 1;
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int score1 = Integer.parseInt(st.nextToken());
                int score2 = Integer.parseInt(st.nextToken());
                applicant.add(new int[]{score1, score2});
                if (score1 == 1) min1 = score2;
                if (score2 == 1) min2 = score1;
            }
            int cnt = 0;
            Collections.sort(applicant, (o1, o2) -> o1[0] - o2[0]);
            for (int j = 0; j < min2; j++) {
                if (applicant.get(j)[1] <= min1) {
                    cnt++;
                    min1 = applicant.get(j)[1];
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}