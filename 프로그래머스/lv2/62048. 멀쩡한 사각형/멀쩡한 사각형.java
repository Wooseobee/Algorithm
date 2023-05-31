class Solution {
    public long solution(int w, int h) {
        long gcd = getGcd(w, h);
        long w1 = w / gcd;
        long h1 = h / gcd;
        long cnt = 0;
        for (long i = 1; i < w1; i++) {
            cnt += (long) h1 * i / w1;
        }
        return (long) w * h - (gcd * ((w1 * h1) - (cnt * 2)));
    }

    private static long getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}