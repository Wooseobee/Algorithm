import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String c4 = br.readLine();
        Stack<Character> stack = new Stack<>();
        int len = str.length();
        int c4Len = c4.length();

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            stack.push(ch);
            if (stack.size() >= c4Len && ch == c4.charAt(c4Len - 1)) {
                boolean canDelete = true;
                for (int j = 0; j < c4Len; j++) {
                    if (stack.get(stack.size() - c4Len + j) != c4.charAt(j)) {
                        canDelete = false;
                        break;
                    }
                }
                if (canDelete) {
                    for (int j = 0; j < c4Len; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
        br.close();
    }
}
