import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int solution1 = 0;
        int solution2 = 0;

        int[] solution = new int[n];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            solution[i] = Integer.parseInt(input[i]);

        }

        Arrays.sort(solution);

        for (int i = 0; i < solution.length; i++) {
            if (solution[i] >= 0 && i != n - 1) {
                int sum = Math.abs(solution[i] + solution[i + 1]);
                if (min > sum) {
                    solution1 = i;
                    solution2 = i + 1;
                }
                break;
            }
            int findMinSolution = findMin(i, n, solution);
            int sum = Math.abs(solution[i] + solution[findMinSolution]);

            if (i != findMinSolution && min > sum) {
                min = sum;
                solution1 = i;
                solution2 = findMinSolution;
            }
        }

        System.out.println(solution[solution1] + " " + solution[solution2]);

        br.close();
    }

    static int findMin(int idx, int n, int[] solution) {
        int low = idx;
        int ans = 0;
        int high = n - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (idx == mid) {
                low = mid + 1;
                continue;
            }

            int sum = Math.abs(solution[idx] + solution[mid]);


            if (Math.abs(solution[idx]) > Math.abs(solution[mid])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            if (sum < min) {
                min = sum;
                ans = mid;
            }
        }

        return ans;
    }
}