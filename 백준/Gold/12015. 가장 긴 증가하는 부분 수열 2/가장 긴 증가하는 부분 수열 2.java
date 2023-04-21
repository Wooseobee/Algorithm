import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        lis[0] = arr[0];
        int lisIdx = 0;
        for (int i = 1; i < n; i++) {
            if (lis[lisIdx] < arr[i]) {
                lis[++lisIdx] = arr[i];
            } else {
                int idx = binarySearch(lis, arr[i], 0, lisIdx);
                lis[idx] = arr[i];
            }
        }

        System.out.println(lisIdx + 1);
        br.close();
    }

    private static int binarySearch(int[] lis, int v, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (lis[mid] < v) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}