import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] solution = new int[n];
        
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            solution[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(solution);

        int i = 0;
        int j = solution.length - 1;
        int min = Integer.MAX_VALUE;
        int solution1 = 0;
        int solution2 = 0;
        while (i < j) {
            int sum = solution[i] + solution[j];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                solution1 = solution[i];
                solution2 = solution[j];
            }
            if (sum > 0) j--;
            else i++;
        }

        System.out.println(solution1 + " " + solution2);
        br.close();
    }
}