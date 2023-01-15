import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        String s = br.readLine();
        String arr[] = s.split("");
        int flag = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case "(":
                    stack.push(arr[i]);
                    flag = 0;
                    break;
                case ")":
                    stack.pop();
                    if (flag == 1) {
                        cnt++;
                    } else {
                        cnt += stack.size();
                    }
                    flag = 1;
                    break;
                default:
                    break;
            }
        }
        System.out.println(cnt);
    }
}