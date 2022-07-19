import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] strarr = s.split("");

        Stack<Double> stack = new Stack<>();

        double a = 0;
        double b = 0;

        double arr[] = new double[26];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < strarr.length; i++) {
            char ch = strarr[i].charAt(0);
            switch (ch) {
                case '*':
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                    break;
                case '+':
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                    break;
                case '-':
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case '/':
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(arr[(int)ch-65]);
                    break;
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));
        br.close();
    }
}