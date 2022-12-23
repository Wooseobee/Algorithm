import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> leftStk = new Stack<>();
        Stack<String> rightStk = new Stack<>();

        String[] s = br.readLine().split("");

        for (int i = 0; i < s.length; i++) {
            leftStk.add(s[i]);
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "L":
                    if (!leftStk.isEmpty()) rightStk.add(leftStk.pop());
                    break;
                case "D":
                    if (!rightStk.isEmpty()) leftStk.add(rightStk.pop());
                    break;
                case "B":
                    if (!leftStk.isEmpty()) leftStk.pop();
                    break;
                case "P":
                    leftStk.add(input[1]);
                    break;
            }
        }

        while (!leftStk.isEmpty()) {
            rightStk.add(leftStk.pop());
        }
        while (!rightStk.isEmpty()) {
            bw.write(rightStk.pop());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}