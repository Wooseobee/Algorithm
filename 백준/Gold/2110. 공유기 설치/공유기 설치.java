import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] homes = new int[n];

        for (int i = 0; i < n; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        System.out.println(installRouter(n, m, homes));

        br.close();
    }

    static int installRouter(int n, int m, int[] homes) {
        int low = 1;
        int high = homes[n - 1] - homes[0] + 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (countCanInstall(mid, n, homes) < m) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }

    static int countCanInstall(int dist, int n, int[] homes) {
        int installed = 0;
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (homes[i] - homes[installed] >= dist) {
                cnt++;
                installed = i;
            }
        }

        return cnt;
    }
}