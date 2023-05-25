class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer;

        answer = getAnswer(arrayA, arrayB);
        answer = Math.max(answer, getAnswer(arrayB, arrayA));

        return answer;
    }

    private static int getAnswer(int[] arrayA, int[] arrayB) {
        int a = arrayA.length > 1 ? gcd(arrayA[0], arrayA[1]) : arrayA[0];
        for (int i = 2; i < arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
        }
        if (checkCanDivide(a, arrayB)) return a;
        return 0;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static boolean checkCanDivide(int a, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % a == 0) return false;
        }
        return true;
    }
}