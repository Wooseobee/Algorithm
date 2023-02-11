import java.util.Arrays;

class Solution {
    public static int solution(String name) {
        int answer = 0;
        int len = name.length();
        char[] answerName = new char[len];
        for (int i = 0; i < len; i++) {
            answerName[i] = 'A';
        }

        int idx = 0;
        while (true) {
            if (answerName[idx] != name.charAt(idx)) {
                answer += Math.min(Math.abs(name.charAt(idx) - 'A'), Math.abs(name.charAt(idx) - 'Z') + 1);
                answerName[idx] = name.charAt(idx);
            }

            if (checkFinish(answerName, name)) break;

            int leftCnt = 0, rightCnt = 0;
            int left = idx, right = idx;
            while (answerName[left] == name.charAt(left)) {
                left--;
                leftCnt++;
                if (left == -1) left = len - 1;
            }
            while (answerName[right] == name.charAt(right)) {
                right++;
                rightCnt++;
                if (right == len) right = 0;
            }
            if (leftCnt >= rightCnt) {
                answer += rightCnt;
                idx = right;
            } else {
                answer += leftCnt;
                idx = left;
            }
        }

        System.out.println(answer);
        return answer;
    }

    static boolean checkFinish(char[] answerName, String name) {
        return String.valueOf(answerName).equals(name);
    }

    public static void main(String[] args) {
        solution("JAZ");
    }
}