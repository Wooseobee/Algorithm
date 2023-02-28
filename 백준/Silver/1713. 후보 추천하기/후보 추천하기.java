import java.io.*;
import java.util.*;

public class Main {
    static class Picture {
        int recommendedNum;
        int duration;
        int student;

        public Picture(int recommendedNum, int duration, int student) {
            this.recommendedNum = recommendedNum;
            this.duration = duration;
            this.student = student;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Picture[] pictures = new Picture[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            boolean register = false;
            int recommend = Integer.parseInt(s[i]);
            for (int j = 0; j < n; j++) {
                if (pictures[j] == null) {
                    pictures[j] = new Picture(1, 0, recommend);
                    register = true;
                    break;
                } else if (recommend == pictures[j].student) {
                    pictures[j].recommendedNum++;
                    register = true;
                    break;
                }
            }
            if (!register) {
                int idx = 0;
                int min = 1_000;
                int duration = 0;
                for (int j = 0; j < n; j++) {
                    if (min > pictures[j].recommendedNum) {
                        idx = j;
                        min = pictures[j].recommendedNum;
                        duration = pictures[j].duration;
                    } else if (min == pictures[j].recommendedNum) {
                        if (duration < pictures[j].duration) {
                            idx = j;
                            duration = pictures[j].duration;
                        }
                    }
                }
                pictures[idx].student = recommend;
                pictures[idx].recommendedNum = 1;
                pictures[idx].duration = 0;
            }
            for (int j = 0; j < n; j++) {
                if (pictures[j] != null) {
                    pictures[j].duration++;
                }
            }
        }

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (pictures[i] != null) {
                set.add(pictures[i].student);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : set) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}