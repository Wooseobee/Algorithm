import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String reverse = new StringBuilder(input).reverse().toString();
        Stack<String> stack = new Stack<>();
        int cnt = 0;

        String[] reverses = reverse.split(" ");
        int len = reverses.length;

        StringBuilder sb = new StringBuilder();
        sb.append(new StringBuilder(reverses[len - 1]).reverse().toString());

        for (int i = 0; i < len - 1; i++) {
            StringBuilder charSb = new StringBuilder();
            boolean flag = false;
            for (int j = 0; j < reverses[i].length(); j++) {
                if (reverses[i].charAt(j) == ';' || reverses[i].charAt(j) == ',' || reverses[i].charAt(j) == ' ') {
                    continue;
                } else if (reverses[i].charAt(j) == '&' || reverses[i].charAt(j) == '*') {
                    sb.append(reverses[i].charAt(j));
                } else if (reverses[i].charAt(j) == '[') {
                    sb.append(']');
                } else if (reverses[i].charAt(j) == ']') {
                    sb.append('[');
                } else if (!flag) {
                    charSb.append(";" + reverses[i].charAt(j));
                    flag=true;
                } else {
                    charSb.append(reverses[i].charAt(j));
                }

                if (j == reverses[i].length() - 1) {
                    charSb.append(" ");
                    stack.add(sb.append(charSb.reverse()).toString());
                    sb.setLength(0);
                    sb.append(new StringBuilder(reverses[len - 1]).reverse().toString());
                    cnt++;
                }
            }
        }

        for (int i = 0; i < cnt; i++) {
            System.out.println(stack.pop());
        }
    }
}