import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int n;
    static int[] arr, op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        op = new int[4];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(input[i]);
        }

        solution(arr[0], 1);

        System.out.println(max + "\n" + min);
    }
    static void solution(int sum, int size){
        if (size == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch (i){
                    case 0:
                        solution(sum + arr[size], size + 1);
                        break;
                    case 1:
                        solution(sum - arr[size], size + 1);
                        break;
                    case 2:
                        solution(sum * arr[size], size + 1);
                        break;
                    case 3:
                        solution(sum / arr[size], size + 1);
                        break;
                }
                op[i]++;
            }
        }
    }
}