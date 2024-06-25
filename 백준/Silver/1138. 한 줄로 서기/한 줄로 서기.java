import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");

        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            ans.add(Integer.parseInt(in[i]), i + 1);
        }

        for (int i = 0; i < n; i++) {
            sb.append(ans.get(i)).append(" ");
        }

        System.out.print(sb);
        br.close();
    }
}
