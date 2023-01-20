import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int n;
    static int[] arr, op, order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        op = new int[4];
        order = new int[n-1];


        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(input[i]);
        }

        solution(0, 0);

        System.out.println(max + "\n" + min);
    }
    static void solution(int idx, int size){
        if (size == n - 1) {
            calculate();
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] != 0) {
                op[i] -= 1;
                order[idx] = i;
                solution(idx + 1, size + 1);
                op[i] += 1;
            }
        }
    }

    static void calculate(){
        int sum = arr[0];
        for (int i = 0; i < n - 1; i++) {
            switch (order[i]){
                case 0:
                    sum += arr[i + 1];
                    break;
                case 1:
                    sum -= arr[i + 1];
                    break;
                case 2:
                    sum *= arr[i + 1];
                    break;
                case 3:
                    if (sum > 0) {
                        sum = ((-1) * sum) / arr[i + 1] * (-1);
                    } else {
                        sum /= arr[i + 1];
                    }
                    break;
            }
        }
        min = Math.min(min, sum);
        max = Math.max(max, sum);
    }
}