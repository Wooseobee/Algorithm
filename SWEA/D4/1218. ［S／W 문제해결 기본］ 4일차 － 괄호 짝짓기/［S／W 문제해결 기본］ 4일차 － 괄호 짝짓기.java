import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;

		Stack<Character> stack = new Stack<>();
		for (int test_case = 1; test_case <= T; test_case++) {
			stack.clear();
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			boolean validate = true;

			for (int i = 0; i < len; i++) {
				if (!validate) break;
				char ch = str.charAt(i);

				switch (ch) {
				case '(':
				case '[':
				case '{':
				case '<':
					stack.push(ch);
					break;

				case ')':
					char top = stack.pop();
					if (top != '(') validate = false;
					break;
				case ']':
					top = stack.pop();
					if (top != '[') validate = false;
					break;
				case '}':
					top = stack.pop();
					if (top != '{') validate = false;
					break;
				case '>':
					top = stack.pop();
					if (top != '<') validate = false;
					break;

				default:
					break;
				}
			}
			sb.append("#").append(test_case).append(" ");
			if (!stack.isEmpty() || !validate) sb.append(0);
			else sb.append(1);
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

}