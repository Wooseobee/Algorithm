import java.io.*;
import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        int len = p.length();

        if (len == 0) {
            return answer;
        } else {
            return divide(p, p, 0);
        }
    }

    static String divide(String p, String w, int firstIdx) {
        if (w.length() == 0) return "";
        int idx = firstIdx + 2;
        String u = p.substring(firstIdx, idx);
        String v;
        while (!checkNum(u)) {
            idx += 2;
            u = p.substring(firstIdx, idx);
        }
        v = p.substring(idx);
        if (checkCorrect(u)) {
            return u + divide(p, v, idx);
        } else {
            return change(u, divide(p, v, idx));
        }
    }

    static String change(String u, String v) {
        StringBuilder tmp = new StringBuilder("(");
        tmp.append(v);
        tmp.append(")");
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') tmp.append(")");
            else tmp.append("(");
        }
        return tmp.toString();
    }

    static boolean checkNum(String s) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt1++;
            else cnt2++;
        }
        return cnt1 == cnt2;
    }

    static boolean checkCorrect(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}