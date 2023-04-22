import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        int[] index = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lisIdx = 0;
        lis[lisIdx] = arr[0];
        index[lisIdx] = lisIdx;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (lis[lisIdx] < arr[i]) {
                lis[++lisIdx] = arr[i];
                index[i] = lisIdx;
            } else {
                int idx = binarySearch(lis, arr[i], 0, lisIdx);
                lis[idx] = arr[i];
                index[i] = idx;
            }
            max = Math.max(max, lisIdx);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lisIdx + 1).append("\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (index[i] == lisIdx) {
                stack.push(arr[i]);
                lisIdx--;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
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