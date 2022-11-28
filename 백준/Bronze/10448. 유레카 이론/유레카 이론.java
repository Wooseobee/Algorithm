import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            List<Integer> tripleList = new ArrayList<>();
            boolean found = false;

            for (int j = 1; j < k; j++) {
                if (checkTriple(j)) {
                    tripleList.add(j);
                }
            }

            for (int j = 0; j < tripleList.size(); j++) {
                if (found) {
                    break;
                }
                for (int l = 0; l < tripleList.size(); l++) {
                    if (found) {
                        break;
                    }
                    for (int m = 0; m < tripleList.size(); m++) {
                        if (tripleList.get(j) + tripleList.get(l) + tripleList.get(m) == k) {
                            System.out.println(1);
                            found = true;
                            break;
                        }
                    }
                }
            }
            
            if (!found) {
                System.out.println(0);
            }
        }
    }

    public static boolean checkTriple(int n) {
        for (int i = 1; i <= n; i++) {
            if (i * (i + 1) == 2 * n) {
                return true;
            }
        }
        return false;
    }
}