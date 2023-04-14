import java.io.*;
import java.util.*;

public class Main {
    static int l, c;
    static char[] comb;
    static boolean[] visited;
    static char[] chars;
    static Set<String> secretKey = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        comb = new char[l];
        chars = new char[c];
        visited = new boolean[c];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < c; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        findCombination(0, 0);

        for (String s : secretKey) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void findCombination(int depth, int idx) {
        if (depth == l) {
            if (canBeSecretKey()) {
                char[] sortArray = comb.clone();
                Arrays.sort(sortArray);
                String s = "";
                for (int i = 0; i < l; i++) {
                    s += sortArray[i];
                }
                secretKey.add(s);
            }
            return;
        }
        for (int i = idx; i < c; i++) {
            if (!visited[i]) {
                visited[i] = true;

                comb[depth] = chars[i];
                findCombination(depth + 1, i + 1);

                visited[i] = false;
            }
        }
    }

    private static boolean canBeSecretKey() {
        int cnt1 = 0;
        boolean cnt2 = false;
        for (int i = 0; i < l; i++) {
            if (comb[i] == 'a' || comb[i] == 'e' || comb[i] == 'i' || comb[i] == 'o' || comb[i] == 'u') {
                cnt2 = true;
            } else {
                cnt1++;
            }
        }
        if (cnt1 >= 2 && cnt2) {
            return true;
        }
        return false;
    }
}