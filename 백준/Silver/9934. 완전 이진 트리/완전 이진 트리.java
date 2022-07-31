import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder[] sb;
    static int[] arr;
    static int level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        level = K;

        sb = new StringBuilder[K];
        for (int i = 0; i < K; i++) {
            sb[i] = new StringBuilder();
        }

        arr = new int[(int) Math.pow(2, K) - 1];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        levelOrder(0, arr.length - 1, 0);
        for (int i = 0; i < K; i++) {
            System.out.println(sb[i]);
        }
        br.close();
    }

    public static void levelOrder(int start, int end, int floor) {

        if (floor == level) {
            return;
        }
        int mid = (start + end) / 2;

        sb[floor].append(arr[mid] + " ");
        levelOrder(start, mid - 1, floor + 1);
        levelOrder(mid + 1, end, floor + 1);
    }
}