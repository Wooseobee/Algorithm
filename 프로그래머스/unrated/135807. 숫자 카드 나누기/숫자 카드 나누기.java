class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int a = arrayA.length > 1 ? gcd(arrayA[0], arrayA[1]) : arrayA[0];
        for (int i = 2; i < arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
        }
        if (checkCanDivide(a, arrayB)) answer = a;

        int b = arrayB.length > 1 ? gcd(arrayB[0], arrayB[1]) : arrayB[0];
        for (int i = 2; i < arrayB.length; i++) {
            b = gcd(b, arrayB[i]);
        }

        if (checkCanDivide(b, arrayA)) answer = Math.max(answer, b);

        return answer == 1 ? 0 : answer;
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